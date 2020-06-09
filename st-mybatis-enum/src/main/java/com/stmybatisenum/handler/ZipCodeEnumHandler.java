package com.stmybatisenum.handler;

import com.stmybatisenum.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@MappedTypes(BaseEnum.class)
public class ZipCodeEnumHandler<E extends BaseEnum> extends BaseTypeHandler<E> {
    private Class<E> type;
    private Map<Integer, E> enumMap;

    public ZipCodeEnumHandler(){}

    public ZipCodeEnumHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        E[] enums = type.getEnumConstants();
        //配置到 <typeHandler> 初始化时，这里的 type 只是一个接口，并不是枚举，所以要特殊判断
        //下面除了第一个 setNonNullParameter 赋值不需要 enumMap，其他 3 个都需要，
        //由于正常情况下实体类不会使用 LabelValue 接口类型，所以这里没有对 null 进行判断
        if (enums != null) {
            this.enumMap = new HashMap<>(enums.length);
            for (int i = 0; i < enums.length; i++) {
                this.enumMap.put(enums[i].getValue(), enums[i]);
            }
        }
    }
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, e.getValue());
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int i = resultSet.getInt(s);
        if (resultSet.wasNull()) {
            return null;
        } else {
            try {
                return enumMap.get(i);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int columnIndex = resultSet.getInt(i);
        if (resultSet.wasNull()) {
            return null;
        } else {
            try {
                return enumMap.get(columnIndex);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int columnIndex = callableStatement.getInt(i);
        if (callableStatement.wasNull()) {
            return null;
        } else {
            try {
                return enumMap.get(columnIndex);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }
}
