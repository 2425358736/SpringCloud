package com.liuzhiqiang.ext;

import com.google.common.escape.Escaper;
import com.google.common.html.HtmlEscapers;

import java.beans.PropertyEditorSupport;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 * <p>
 * json字符串转换
 * @author anming
 * @created 2018/2/26.
 */
public class StringEscapeEditor extends PropertyEditorSupport {
    public StringEscapeEditor() {}

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            setValue(null);
        } else {
            Escaper htmlEscaper = HtmlEscapers.htmlEscaper();
            setValue(htmlEscaper.escape(text));
        }
    }

}
