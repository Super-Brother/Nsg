package top.yokey.nsg.system;

import net.tsz.afinal.http.AjaxParams;

import java.io.File;
import java.io.FileNotFoundException;

import top.yokey.nsg.activity.NcApplication;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：带 key 的 ajaxParams
*
*/

public class SellerAjaxParams extends AjaxParams {

    public SellerAjaxParams(NcApplication application) {
        this.put("key", application.sellerKeyString);
    }

    @Override
    public void put(String key, String value) {
        super.put(key, value);
    }

    @Override
    public void put(String key, File file) throws FileNotFoundException {
        super.put(key, file);
    }

    public void putAct(String value) {
        this.put("act", value);
    }

    public void putOp(String value) {
        this.put("op", value);
    }

}
