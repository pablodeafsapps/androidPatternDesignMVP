package org.deafsapps.androidpatterndesignmvp.model;

import junit.framework.Assert;

import org.deafsapps.androidpatterndesignmvp.BuildConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Date;

/**
 * Created by Pablo L on 28/11/2016.
 */
@RunWith(RobolectricTestRunner.class)   // 'Robolectric allows to use a Context instance
@Config(constants = BuildConfig.class, sdk = 23)
public class TestReturnData {

    private static final String STRING_SAMPLE = "String sample";
    private static final long ARBITRARY_DATE_MILLISECONDS = 800000000;

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testReturnData() {
        ReturnData returnData_1 = new ReturnData(TestReturnData.STRING_SAMPLE);
        Assert.assertTrue(returnData_1 != null);
        System.out.println(returnData_1);
        ReturnData returnData_2 = new ReturnData(TestReturnData.STRING_SAMPLE, new Date(TestReturnData.ARBITRARY_DATE_MILLISECONDS));
        Assert.assertTrue(returnData_2 != null);
        System.out.println(returnData_2);
    }
}
