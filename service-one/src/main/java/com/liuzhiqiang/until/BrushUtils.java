package com.liuzhiqiang.until;

import com.liuzhiqiang.config.page.Pagination;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 * <p>
 * 类功能描述
 *
 * @author 刘志强
 * @created 2018/3/29.
 */
@Component
public class BrushUtils{
    private List<Map<String,Object>> export;

    /**
     * 1 不分页
     */
    private int notPage;
    /**
     *分页排序
     */
    private Pagination pagination = new Pagination();

    /**
     * 查询
     */
    private Map<String, Object> filters = new HashMap<>();



    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Map<String, Object> getFilters() {return filters;}

    public void setFilters(Map<String, Object> filters) {
        this.filters = filters;
    }

    public List<Map<String, Object>> getExport() {
        return export;
    }

    public void setExport(List<Map<String, Object>> export) {
        this.export = export;
    }

    public int getNotPage() {
        return notPage;
    }

    public void setNotPage(int notPage) {
        this.notPage = notPage;
    }
}
