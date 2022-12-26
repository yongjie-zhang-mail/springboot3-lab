package com.yj.lab.common.model.vo.es;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author Zhang Yongjie
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NameValueAndChildren implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 2439668390619490098L;
    private String name;
    private String value;
    private List<NameValueAndChildren> children;

    public NameValueAndChildren(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
