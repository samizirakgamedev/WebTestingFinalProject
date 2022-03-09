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
     * Creates the driver of choice for the user with the headless option enabled - Will only work if the browser supports this.
     */
    protected abstract void createHeadlessDriver();
    /**
     * Creates the driver of choice for the user with a screen (browser) size and resolution of the MobilePhoneType of choice.
     * @param type MobilePhoneType that defines the height and width of the mobile phone.
     */
    protected abstract void createPhoneDriver(MobilePhoneType type);

    /**
     * Manager method that can be called to terminate the active driver by stopping the service and quitting it.
     * NOTE: Sets the driver to null after termination.
     */
    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            stopService();
            driver = null;
        }
    }
    /**
     * Manager method that can be called to create a WebDriver of choice and return it.
     * Starts the drivers the service for the driver in advance of creating it.
     * Note: Default filepath for driver is: src/test/resources/drivers/[Driver name]
     * @return Returns the created WebDriver
     */
    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }
    /**
     * Manager method that can be called to create a WebDriver of choice in "headless mode" and return it.
     * Starts the drivers the service for the driver in advance of creating it.
     * Note: Default filepath for driver is: src/test/resources/drivers/[Driver name]
     * @return Returns the created WebDriver. Note: Will return a browser that isn't headless if the browser doesn't support headless mode.
     */
    public WebDriver getHeadlessDriver() {
        if (null == driver) {
            startService();
            createHeadlessDriver();
        }
        return driver;
    }
    /**
     * Manager method that can be called to create a WebDriver of choice with a screen (browser) size and resolution of the MobilePhoneType of choice and then return it.
     * Note: Default filepath for driver is: src/test/resources/drivers/[Driver name].
     * @param type MobilePhoneType that defines the height and width of the mobile phone.
     * @return Returns the created WebDriver
     */
    public WebDriver getMobilePhoneDriver(MobilePhoneType type) {
        if (null == driver) {
            startService();
            createPhoneDriver(type);
        }
        return driver;
    }
    /**
     * Manager method that can be called to create a WebDriver of choice and return it.
     * @param filePath Custom file path to the driver needed to run the WebDriver.
     * @return Returns the created WebDriver
     */
    public WebDriver getDriverWithCustomPath(String filePath) {
        if (null == driver) {
            startService(filePath);
            createDriver();
        }
        return driver;
    }
    /**
     * Manager method that can be called to create a WebDriver of choice in "headless mode" and return it.
     * @param filePath Custom file path to the driver needed to run the WebDriver.
     * @return Returns the created WebDriver. Note: Will return a browser that isn't headless if the browser doesn't support headless mode.
     */
    public WebDriver getHeadlessDriverWithCustomPath(String filePath) {
        if (null == driver) {
            startService(filePath);
            createHeadlessDriver();
        }
        return driver;
    }
    /**
     * Manager method that can be called to create a WebDriver of choice with a screen (browser) size and resolution of the MobilePhoneType of choice and then return it.
     * @param filePath Custom file path to the driver needed to run the WebDriver.
     * @param type MobilePhoneType that defines the height and width of the mobile phone.
     * @return Returns the created WebDriver.
     */
    public WebDriver getMobilePhoneDriverWithCustomPath(String filePath, MobilePhoneType type) {
        if (null == driver) {
            startService(filePath);
            createPhoneDriver(type);
        }
        return driver;
    }
}
