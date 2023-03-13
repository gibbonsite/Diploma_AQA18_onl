package utils;

import baseentities.BaseEntity;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.model.Status.PASSED;
import static io.qameta.allure.model.Status.SKIPPED;

public class AllureScreenshotPublisher extends BaseEntity implements StepLifecycleListener {

    @Override
    public void afterStepUpdate(StepResult result) {
        if (result.getStatus() != PASSED && result.getStatus() != SKIPPED) {
            addAttachment("Screenshot", new ByteArrayInputStream(
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

}
