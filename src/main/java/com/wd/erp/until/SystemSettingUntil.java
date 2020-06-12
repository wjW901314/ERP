package com.wd.erp.until;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="define")
@PropertySource("classpath:define.properties")
public class SystemSettingUntil {
    private String codeLong5;
    private String codeLong10;

    private String pname;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public String getCodeLong5() {
        return codeLong5;
    }

    public void setCodeLong5(String codeLong5) {
        this.codeLong5 = codeLong5;
    }

    public String getCodeLong10() {
        return codeLong10;
    }

    public void setCodeLong10(String codeLong10) {
        this.codeLong10 = codeLong10;
    }
}
