package com.stormphoenix.graduatedesign;

import com.alicloud.openservices.tablestore.SyncClient;
import com.alicloud.openservices.tablestore.model.*;
import com.stormphoenix.graduatedesign.constants.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrajectorMapApiApplicationTests {

    public static int count = 0;
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_TRAJECTORY_ID = "trajectory_id";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";


    public static final String END_POINT = "https://GPS-Sample2.cn-hangzhou.ots.aliyuncs.com";
    public static final String ACCESS_KEY_ID = "LTAIfcYPIEOTQTdO";
    public static final String ACCESS_KEY_SECRET = "fzGryKL57qkathfilUa2uUPDgtiEVN";
    public static final String INSTANCE_NAME_GPS_SAMPLE = "GPS-Sample2";
    public static final String TRAJECTOR_DATA_TABLE_NAME = "user_trajectory";
    public static SyncClient client = new SyncClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET, INSTANCE_NAME_GPS_SAMPLE);

    @Test
    public void contextLoads() {
    }

    @Test
    public void queryByUserId() {
        // 等同于 SELECT * FROM UserHistory WHERE user_id = '10100'
        RangeRowQueryCriteria rangeRowQueryCriteria = new RangeRowQueryCriteria(TRAJECTOR_DATA_TABLE_NAME);
        // 设置起始主键
        PrimaryKeyBuilder primaryKeyBuilder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
        primaryKeyBuilder.addPrimaryKeyColumn(COLUMN_USER_ID, PrimaryKeyValue.fromString("032"));
        primaryKeyBuilder.addPrimaryKeyColumn(COLUMN_TRAJECTORY_ID, PrimaryKeyValue.fromLong(1228318146000L));
        primaryKeyBuilder.addPrimaryKeyColumn(COLUMN_TIMESTAMP, PrimaryKeyValue.fromLong(1228318146000L));
        rangeRowQueryCriteria.setInclusiveStartPrimaryKey(primaryKeyBuilder.build());
//         设置结束主键
        primaryKeyBuilder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
        primaryKeyBuilder.addPrimaryKeyColumn(COLUMN_USER_ID, PrimaryKeyValue.fromString("032"));
        primaryKeyBuilder.addPrimaryKeyColumn(COLUMN_TRAJECTORY_ID, PrimaryKeyValue.fromLong(1228318891000L));
        primaryKeyBuilder.addPrimaryKeyColumn(COLUMN_TIMESTAMP, PrimaryKeyValue.fromLong(1228318891000L));
        rangeRowQueryCriteria.setExclusiveEndPrimaryKey(primaryKeyBuilder.build());
        // 设置读取最新版本
        rangeRowQueryCriteria.setMaxVersions(1);
        // 默认读取所有的属性列
        GetRangeResponse response = client.getRange(new GetRangeRequest(rangeRowQueryCriteria));
        List<Row> rows = response.getRows();
        for (Row row : rows) {
            List<Column> columns = row.getColumn(Constants.COLUMN_NAME_LATITUDE);
            System.out.println();
        }
    }
}