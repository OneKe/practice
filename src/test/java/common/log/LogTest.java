package common.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void print1() {
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
        logger.error("error");
        logger.warn("warn");
    }
}
