package com.druid.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.alibaba.druid.stat.DruidStatService;
import com.alibaba.druid.support.http.stat.WebAppStatManager;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.support.spring.stat.SpringStatManager;
import com.alibaba.druid.util.MapComparator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/monitor")
public class DruidStatController {

    private static DruidStatManagerFacade statManagerFacade = DruidStatManagerFacade.getInstance();
    public final static int               RESULT_CODE_SUCCESS    = 1;
    public final static int               RESULT_CODE_ERROR      = -1;

    private final static int              DEFAULT_PAGE           = 1;
    private final static int              DEFAULT_PER_PAGE_COUNT = Integer.MAX_VALUE;
    private static final String           ORDER_TYPE_DESC        = "desc";
    private static final String           ORDER_TYPE_ASC         = "asc";
    private static final String           DEFAULT_ORDER_TYPE     = ORDER_TYPE_ASC;
    private static final String           DEFAULT_ORDERBY        = "SQL";

    @GetMapping("/basic")
    public Object basic() {
        // TODO 定制化
        return DruidStatManagerFacade.getInstance().returnJSONBasicStat();
    }

    @GetMapping("/reset-all")
    public void resetAll() {
        // TODO 定制化
        statManagerFacade.resetAll();
    }

    @GetMapping("/log-and-reset")
    public void logAndReset() {
        // TODO 定制化
        DruidStatManagerFacade.getInstance().logAndResetDataSource();
    }

    @GetMapping("/datasource")
    public Object druidStat() {
        // TODO 定制化
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return statManagerFacade.getDataSourceStatDataList();
    }

    @GetMapping("/activeConnectionStackTrace")
    public Object activeConnectionStackTrace() {
        // TODO 定制化
        return statManagerFacade.getActiveConnStackTraceList();
    }

    /**
     *
     * @param id
     * @return
     * datasource-
     */
    @GetMapping("/getDataSourceStatDataById")
    public Object getDataSourceStatDataById(Integer id) {
        // TODO 定制化
        Object result = statManagerFacade.getDataSourceStatData(id);
        return result == null ? RESULT_CODE_ERROR : result;
    }

    /**
     * connectionInfo-
     * @param id
     * @return
     */
    @GetMapping("/getPoolingConnectionInfoByDataSourceId")
    public Object getPoolingConnectionInfoByDataSourceId(Integer id) {
        // TODO 定制化
        List<?> connectionInfoList = statManagerFacade.getPoolingConnectionInfoByDataSourceId(id);
        return connectionInfoList == null ? RESULT_CODE_ERROR : connectionInfoList;
    }

    /**
     * activeConnectionStackTrace-
     * @param id
     * @return
     */
    @GetMapping("/activeConnectionStackTraceById")
    public Object activeConnectionStackTraceById(Integer id) {
        // TODO 定制化
        return statManagerFacade.getActiveConnectionStackTraceByDataSourceId(id);
    }

    @GetMapping("/sql")
    public Object sql() {
        String result = DruidStatService.getInstance().service("/sql.json");
        Map<String, Object> resultMap = (Map<String, Object>) JSONUtils.parse(result);
        // TODO 定制化
        log.info(resultMap.toString());
        return resultMap;
    }

    @GetMapping("/wall")
    public Object wall(@RequestParam(required = false) Map<String, String> parameters) {
        // TODO 定制化
        Integer dataSourceId = null;

        String dataSourceIdParam = parameters.get("dataSourceId");
        if (dataSourceIdParam != null && dataSourceIdParam.length() > 0) {
            dataSourceId = Integer.parseInt(dataSourceIdParam);
        }

        Map<String, Object> result = statManagerFacade.getWallStatMap(dataSourceId);

        if (result != null) {
            List<Map<String, Object>> tables = (List<Map<String, Object>>) result.get("tables");
            if (tables != null) {
                List<Map<String, Object>> sortedArray = comparatorOrderBy(tables, parameters);
                result.put("tables", sortedArray);
            }

            List<Map<String, Object>> functions = (List<Map<String, Object>>) result.get("functions");
            if (functions != null) {
                List<Map<String, Object>> sortedArray = comparatorOrderBy(functions, parameters);
                result.put("functions", sortedArray);
            }
        } else {
            result = Collections.emptyMap();
        }

        return result;
    }

    /**
     * wall-
     * @param id
     * @return
     */
    @GetMapping("/getWallById")
    public Object getWallById(Integer id) {
        // TODO 定制化
        return statManagerFacade.getWallStatMap(id);
    }

    @GetMapping("/getsqlById")
    public Object getsqlById(Integer id) {
        // TODO 定制化
        return statManagerFacade.getSqlStatData(id);
    }

    @GetMapping("/weburi")
    public Object weburi(@RequestParam(required = false)Map<String, String> parameters) {
        // TODO 定制化
        List<Map<String, Object>> array = WebAppStatManager.getInstance().getURIStatData();
        return comparatorOrderBy(array, parameters);
    }

    /**
     * weburi-
     * @param uri
     * @return
     */
    @GetMapping("/weburiByUri")
    public Object weburiByUri(String uri) {
        // TODO 定制化
        return WebAppStatManager.getInstance().getURIStatData(uri);
    }

    @GetMapping("/webapp")
    public Object webapp(@RequestParam(required = false)Map<String, String> parameters) {
        // TODO 定制化
        List<Map<String, Object>> array = WebAppStatManager.getInstance().getWebAppStatData();
        return comparatorOrderBy(array, parameters);
    }

    @GetMapping("/websession")
    public List<Map<String, Object>> websession(@RequestParam(required = false)Map<String, String> parameters) {
        // TODO 定制化
        List<Map<String, Object>> array = WebAppStatManager.getInstance().getSessionStatData();
        return comparatorOrderBy(array, parameters);
    }

    /**
     *websession-
     * @param sessionId
     * @return
     */
    @GetMapping("/websessionBySessionId")
    public Map<String, Object> websessionBySessionId(String sessionId) {
        // TODO 定制化
        return WebAppStatManager.getInstance().getSessionStat(sessionId);
    }

    @GetMapping("/spring")
    public List<Map<String, Object>> spring(@RequestParam(required = false)Map<String, String> parameters) {
        List<Map<String, Object>> array = SpringStatManager.getInstance().getMethodStatData();
        // TODO 定制化
        return comparatorOrderBy(array, parameters);
    }

    @GetMapping("/springDetail")
    public Map<String, Object> springDetail(String clazz, String method) {
        // TODO 定制化
        return SpringStatManager.getInstance().getMethodStatData(clazz, method);
    }

    private List<Map<String, Object>> comparatorOrderBy(List<Map<String, Object>> array, Map<String, String> parameters) {
        // when open the stat page before executing some sql
        if (array == null || array.isEmpty()) {
            return null;
        }

        // when parameters is null
        String orderBy, orderType = null;
        Integer page = DEFAULT_PAGE;
        Integer perPageCount = DEFAULT_PER_PAGE_COUNT;
        if (parameters == null) {
            orderBy = DEFAULT_ORDERBY;
            orderType = DEFAULT_ORDER_TYPE;
            page = DEFAULT_PAGE;
            perPageCount = DEFAULT_PER_PAGE_COUNT;
        } else {
            orderBy = parameters.get("orderBy");
            orderType = parameters.get("orderType");
            String pageParam = parameters.get("page");
            if (pageParam != null && pageParam.length() != 0) {
                page = Integer.parseInt(pageParam);
            }
            String pageCountParam = parameters.get("perPageCount");
            if (pageCountParam != null && pageCountParam.length() > 0) {
                perPageCount = Integer.parseInt(pageCountParam);
            }
        }

        // others,such as order
        orderBy = orderBy == null ? DEFAULT_ORDERBY : orderBy;
        orderType = orderType == null ? DEFAULT_ORDER_TYPE : orderType;

        if (!ORDER_TYPE_DESC.equals(orderType)) {
            orderType = ORDER_TYPE_ASC;
        }

        // orderby the statData array
        if (orderBy.trim().length() != 0) {
            Collections.sort(array, new MapComparator<String, Object>(orderBy, ORDER_TYPE_DESC.equals(orderType)));
        }

        // page
        int fromIndex = (page - 1) * perPageCount;
        int toIndex = page * perPageCount;
        if (toIndex > array.size()) {
            toIndex = array.size();
        }

        return array.subList(fromIndex, toIndex);
    }
}
