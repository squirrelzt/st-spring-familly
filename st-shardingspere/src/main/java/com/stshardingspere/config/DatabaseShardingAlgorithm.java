package com.stshardingspere.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class DatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String db_name="ds";
        Long num= preciseShardingValue.getValue()%2;
        db_name=db_name + num;
//        System.out.println("----------------db_name:" + db_name);

        for (String each : collection) {
            System.out.println("ds:" + each);
            if (each.equals(db_name)) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
