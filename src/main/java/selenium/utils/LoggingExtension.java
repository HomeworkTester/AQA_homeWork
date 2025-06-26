package selenium.utils;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println(">>> START: " + context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println("<<< END: " + context.getDisplayName());
    }
}