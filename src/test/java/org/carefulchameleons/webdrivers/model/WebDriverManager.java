package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {
    /**
     * WebDriver that is defined by the choice of user.
     */
    protected WebDriver driver;
    /**
     * Starts the driver services using a custom filepath for the driver.
     * @param filepath Filepath for the driver executable.
     */
    protected abstract void startService(String filepath);
    /**
     * Starts the driver services using a default filepath.
     */
    protected abstract void startService();
    /**
     * Terminates the drivers service when called.
     */
    protected abstract void stopService();
    /**
     * Creates the driver of choice for the user.
     */
    protected abstract void createDriver();
    /**
     * Manager method that can be called to terminate the active driver by stopping the service and quitting it.
     * Sets the driver to null after termination.
     */
    public void quitDriver() {
        if (null != driver) {
            stopService();
            driver.quit();
            driver = null;
        }
    }
    /**
     * Manager method that can be called to create a WebDriver of choice and return it.
     * Starts the drivers the service for the driver in advance of creating it.
     * Note: Default filepath for driver is: src/test/resources/drivers/[Driver name]
     */
    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }
    /**
     * Manager method that can be called to create a WebDriver of choice and return it.
     * Can be called with a custom file path to the driver needed to run the WebDriver.
     */
    public WebDriver getDriverWithCustomPath(String filePath) {
        if (null == driver) {
            startService(filePath);
            createDriver();
        }
        return driver;
    }
}
