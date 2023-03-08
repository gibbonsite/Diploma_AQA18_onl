pipeline {
    agent any    

    tools {
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }
    
    stages {
        stage('Build') {
            steps {
                // Get project's code from GitHub
                git branch: "${params.BRANCH}", url: 'https://github.com/gibbonsite/Diploma_AQA18_onl.git'
                
                // Use GitHub test user credentials to run tests
                withCredentials([usernamePassword(credentialsId: 'jenkins-DiplomaAqa18Onl-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    bat "mvn -Dtest=SmokeCucumberTest -Dgithub_username=%USERNAME% -Dgithub_password=%PASSWORD% clean test"
                }

                script {
                    allure([
                        includeProperties: true,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                        ]
                        )
                }
            }
            
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    
                    // Notify about success to Telegram chat
                    withCredentials([string(credentialsId: 'Diploma_AQA18_onl_telegram_bot_token', variable: 'TOKEN'), string(credentialsId: 'Diploma_AQA18_onl_telegram_chat_id', variable: 'CHAT_ID')]) {
                        bat "curl.exe -s -X POST https://api.telegram.org/bot%TOKEN%/sendMessage -d chat_id=%CHAT_ID% -d text=\"Pipeline ${env.JOB_NAME}/${currentBuild.number}. Branch: ${params.BRANCH} Build: SUCCESS\""
                    }
                }
                aborted {
                    // Notify to Telegram chat
                    withCredentials([string(credentialsId: 'Diploma_AQA18_onl_telegram_bot_token', variable: 'TOKEN'), string(credentialsId: 'Diploma_AQA18_onl_telegram_chat_id', variable: 'CHAT_ID')]) {
                        bat "curl.exe -s -X POST https://api.telegram.org/bot%TOKEN%/sendMessage -d chat_id=%CHAT_ID% -d text=\"Pipeline ${env.JOB_NAME}/${currentBuild.number}. Branch: ${params.BRANCH} Build: ABORTED\""
                    }
                }
                failure {
                    // Notify to Telegram chat
                    withCredentials([string(credentialsId: 'Diploma_AQA18_onl_telegram_bot_token', variable: 'TOKEN'), string(credentialsId: 'Diploma_AQA18_onl_telegram_chat_id', variable: 'CHAT_ID')]) {
                        bat "curl.exe -s -X POST https://api.telegram.org/bot%TOKEN%/sendMessage -d chat_id=%CHAT_ID% -d text=\"Pipeline ${env.JOB_NAME}/${currentBuild.number}. Branch: ${params.BRANCH} Build: FAILURE\""
                    }
                }
            }
        }
    }
}
