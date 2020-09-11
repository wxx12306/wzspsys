package cn.stylefeng.guns.modular.test.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.sys.modular.system.entity.WzspYhdd;
import cn.stylefeng.guns.sys.modular.system.entity.wzspWdye;
import cn.stylefeng.guns.sys.modular.system.model.params.ChangXiaoPaiMingParam;
import cn.stylefeng.guns.sys.modular.system.model.params.WzspYhddParam;
import cn.stylefeng.guns.sys.modular.system.model.params.WzspYhyeParam;
import cn.stylefeng.guns.sys.modular.system.model.params.XiaoShouECXParam;
import cn.stylefeng.guns.sys.modular.system.model.result.ChangXiaoPaiMingResult;
import cn.stylefeng.guns.sys.modular.system.model.result.XiaoShouECXResult;
import cn.stylefeng.guns.sys.modular.system.service.ChangXiaoPaiMingService;
import cn.stylefeng.guns.sys.modular.system.service.WzspYhddService;
import cn.stylefeng.guns.sys.modular.system.service.WzspYhyeService;
import cn.stylefeng.guns.sys.modular.system.service.XiaoShouECXService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 订单商品完成表控制器
 *
 * @author cuipengcheng
 * @Date 2020-08-24 19:43:07
 */
@Controller
@RequestMapping("/dpzs")
public class DpzsController extends BaseController {

//    private String PREFIX = "/bestSellerRanking";

    @Autowired
    private ChangXiaoPaiMingService changXiaoPaiMingService;
    @Autowired
    private WzspYhddService wzspYhddService;
    @Autowired
    private WzspYhyeService wzspYhyeService;
    @Autowired
    private XiaoShouECXService xiaoShouEcxService;

    /**
     * 跳转到畅销排名
     *
     * @author cuipengcheng
     * @Date 2020-08-24
     */
    @RequestMapping("")
    public String index() {
        return "/dpzs.html";
    }
//    PREFIX +
    /**
     * 查询畅销商品销售数量列表
     *
     * @author cuipengcheng
     * @Date 2020-08-24
     */
    @ResponseBody
    @RequestMapping("/changXiaoList")
    public List<ChangXiaoPaiMingResult> changXiaoList(ChangXiaoPaiMingParam changXiaoPaiMingParam) {
        return this.changXiaoPaiMingService.findChangXiaoList(changXiaoPaiMingParam);
    }

    /**
     * 查询畅销商品销售金额列表
     *
     * @author cuipengcheng
     * @Date 2020-08-24
     */
    @ResponseBody
    @RequestMapping("/changXiaoMoneyList")
    public List<ChangXiaoPaiMingResult> changXiaoMoneyList(ChangXiaoPaiMingParam changXiaoPaiMingParam) {
        return this.changXiaoPaiMingService.findChangXiaoMoneyList(changXiaoPaiMingParam);
    }



    /**
     * 新增接口
     *
     * @author
     * @Date 2020-08-25
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(WzspYhddParam wzspYhddParam) {
        this.wzspYhddService.add(wzspYhddParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author
     * @Date 2020-08-25
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(WzspYhddParam wzspYhddParam) {
        this.wzspYhddService.update(wzspYhddParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author
     * @Date 2020-08-25
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(WzspYhddParam wzspYhddParam) {
        this.wzspYhddService.delete(wzspYhddParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author
     * @Date 2020-08-25
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(WzspYhddParam wzspYhddParam) {
        WzspYhdd detail = this.wzspYhddService.getById(wzspYhddParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author
     * @Date 2020-08-25
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(WzspYhddParam wzspYhddParam) {
        System.out.println(this.wzspYhddService.findPageBySpec(wzspYhddParam));
        return this.wzspYhddService.findPageBySpec(wzspYhddParam);
    }


    /**
     * 搜索接口
     *
     * @author
     * @Date 2020-08-25
     */
    @ResponseBody
    @RequestMapping("/ss")
    public LayuiPageInfo ss(WzspYhyeParam wzspYhyeParam, HttpServletRequest request, HttpServletResponse response) {
        String content=request.getParameter("content");
        System.out.println(content);
        return this.wzspYhyeService.ss(content,wzspYhyeParam);
    }

    /**
     * 查询总额
     *
     * @author
     * @Date 2020-08-25
     */
    @ResponseBody
    @RequestMapping("/ze")
    public wzspWdye ze(WzspYhyeParam wzspYhyeParam){
        System.out.println("11");
        wzspWdye k=this.wzspYhyeService.ze();
        System.out.println();
        return k;
    }
    /**
     * 查询客户增加数
     *
     * @author
     * @Date 2020-08-25
     */
    @ResponseBody
    @RequestMapping("/rzjs")
    public  wzspWdye rzjs(WzspYhyeParam wzspYhyeParam){
        System.out.println("11");
        wzspWdye k=this.wzspYhyeService.rzjs();
        System.out.println(k);
        return  k;
    }
    /**
     * 查询个人余额
     *
     * @author
     * @Date 2020-08-25
     */
    @ResponseBody
    @RequestMapping("/grye")
    public wzspWdye grye(HttpServletRequest request, HttpServletResponse response){
        System.out.println("11");
        long id=Long.parseLong(request.getParameter("id"));
        wzspWdye  k=this.wzspYhyeService.grye(id);
        System.out.println(id);
        return  k;
    }



    /**
     * 销售额查询时间判断
     *
     * @author cuipengcheng
     * @Date 2020-08-17
     * @return
     */
    @ResponseBody
    @RequestMapping("/xiaoShouECXPanDuan")
    public ResponseData xiaoShouECXPanDuan(XiaoShouECXParam xiaoShouECXParam, HttpServletRequest request) {
        String value = request.getParameter("timeInterval");

        if(value == null || value.equals("0")){
            //return allXiaoShouECX();
            return lastThirtyDays();
        }else if(value.equals("1")){
            return yearXiaoShouECX(xiaoShouECXParam, request);
        }else if(value.equals("2")){
            return monthXiaoShouECX(xiaoShouECXParam, request);
        }else if(value.equals("3")){
            return dayXiaoShouECX(xiaoShouECXParam, request);
        }else{
            return null;
        }

    }

    /**
     * 获取全部的销售额
     *
     * @author cuipengcheng
     * @Date 2020-08-17
     * @return
     */
    @ResponseBody
    @RequestMapping("/allXiaoShouECX")
    public ResponseData allXiaoShouECX() {
        List<XiaoShouECXResult> list = this.xiaoShouEcxService.findAllXiaoShouE();
        list.get(0).setTimes("销售总额");
        return ResponseData.success(list);
    }

    /**
     * 获取指定年份的销售额
     *
     * @author cuipengcheng
     * @Date 2020-08-17
     * @return
     */
    @ResponseBody
    @RequestMapping("/yearXiaoShouECX")
    public ResponseData yearXiaoShouECX(XiaoShouECXParam xiaoShouECXParam, HttpServletRequest request) {
        List<XiaoShouECXResult> list = this.xiaoShouEcxService.findYearXiaoShouE(times(xiaoShouECXParam, request));
        return ResponseData.success(list);
    }

    /**
     * 获取当前年份每月的销售总额(大屏展示使用) or
     * 获取指定月份的销售额
     *
     * @author cuipengcheng
     * @Date 2020-08-17
     * @return
     */
    @ResponseBody
    @RequestMapping("/monthXiaoShouECX")
    public ResponseData monthXiaoShouECX(XiaoShouECXParam xiaoShouECXParam, HttpServletRequest request) {
        List<XiaoShouECXResult> list = this.xiaoShouEcxService.findMonthXiaoShouE(times(xiaoShouECXParam, request));
        return ResponseData.success(list);
    }

    /**
     * 获取当前月份每天的销售总额(大屏展示使用) or
     * 获取指定天数的销售总额
     *
     * @author cuipengcheng
     * @Date 2020-08-17
     * @return
     */
    @ResponseBody
    @RequestMapping("/dayXiaoShouECX")
    public ResponseData dayXiaoShouECX(XiaoShouECXParam xiaoShouECXParam, HttpServletRequest request) {
        List<XiaoShouECXResult> list = this.xiaoShouEcxService.findDayXiaoShouE(times(xiaoShouECXParam, request));
        return ResponseData.success(list);
    }

    /**
     * 获取每个部门的销售总额（大屏展示用）
     *
     * @author cuipengcheng
     * @Date 2020-08-17
     * @return
     */
    @ResponseBody
    @RequestMapping("/deptXiaoShouECX")
    public ResponseData deptXiaoShouECX() {
        List<XiaoShouECXResult> list = this.xiaoShouEcxService.findDeptXiaoShouE();
        return ResponseData.success(list);
    }

    /**
     * 查询时间的赋值封装（应该是叫封装吧，凑合着叫吧）
     * @return
     */
    public XiaoShouECXParam times(XiaoShouECXParam xiaoShouECXParam, HttpServletRequest request){
        xiaoShouECXParam.setTimes(request.getParameter("selection"));
        return xiaoShouECXParam;
    }

    /**
     * 获取最近30天每天的销售额度
     *
     * @author cuipengcheng
     * @Date 2020-08-17
     * @return
     */
    @ResponseBody
    @RequestMapping("/lastThirtyDays")
    public ResponseData lastThirtyDays() {
        List<XiaoShouECXResult> list = this.xiaoShouEcxService.findLastThirtyDays();
        return ResponseData.success(list);
    }


}

