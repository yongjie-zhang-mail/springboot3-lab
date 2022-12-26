package com.yj.lab.common.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyj21
 * 通用 Constant
 */
public class CommonConstant {


    /**
     * 租户
     */
    public static class Tenant {
        /**
         * 线下租户ID 25
         */
        public static final String OFF_LINE_TENANT = "25";

        /**
         * 线下租户ID_整型 25
         */
        public static final Integer OFF_LINE_TENANT_INT = 25;
    }

    /**
     * 激活状态
     */
    public static class ActivateState {

        /**
         * 0:未激活
         */
        public static final Integer NOT_ACTIVATE = 0;
        /**
         * 1:激活
         */
        public static final Integer ACTIVATED = 1;
    }

    /**
     * (0:未处理,1:处理成功,2:处理失败)
     */
    public static class TmpUserMemberState {

        /**
         * 0:未处理
         */
        public static final Integer UNHANDLED = 0;
        /**
         * 1:处理成功
         */
        public static final Integer PROCESSING_SUCCEEDED = 1;
        /**
         * 1:处理失败
         */
        public static final Integer PROCESSING_FAILED = 2;
        /**
         * 3:二次处理
         */
        public static final Integer DOUBLE_PROCESSING = 3;
    }

    /**
     * 切面使用到的常量
     */
    public static class Aspect {

        /**
         * unionId
         */
        public static final String UNION_ID = "unionId";

        /**
         * tenantId
         */
        public static final String TENANT_ID = "tenantId";

        /**
         * tenantId   ACCESS_TOKEN
         */
        public static final String OPEN_ID = "openId";

        /**
         * ACCESS_TOKEN
         */
        public static final String ACCESS_TOKEN = "accessToken";
        /**
         * clientId
         */
        public static final String CLIENT_ID = "clientId";
        /**
         * aip生成的token
         */
        public static final String SERVICE_TOKEN = "serviceToken";
        /**
         * jsonp callback
         */
        public static final String CALLBACK = "callback";

        /**
         * redis里的key
         */
        public static final String TOKEN = "token";

        /**
         * 门店权限校验loginId
         */
        public static final String LOGIN_ID = "loginId";
    }

    /**
     * PC端==移动端
     */
    public static class ClientType {

        /**
         * 所有端
         */
        public static final String ALL = "0";
        public static final Integer ALL_INT = 0;
        /**
         * PC端
         */
        public static final String PC = "1";
        /**
         * 移动端
         */
        public static final String MOVE = "2";
        public static final Integer MOVE_ALL = 2;
        /**
         * 微信端
         */
        public static final String WECHAT = "3";
        /**
         * 微信小程序端
         */
        public static final String SMALL_PROGRAM = "4";

        /**
         * app
         */
        public static final String APP = "5";


        public static List<Integer> CLIENT_ID_LIST = Arrays.asList(0, 1, 2, 3, 4, 5);
    }

    public interface Token {

        /**
         * token 前缀
         */
        String TOKEN_PRE = "Bearer ";
    }

    /**
     * Redis Key
     */
    public static class Redis {

        /**
         * 用户黑名单 key
         */
        public static final String BLACK_USER_KEY = "black_user:";
        /**
         * 黑名单过期时间, 30分钟
         */
        public static final int BLACK_KEY_TIME = 60 * 30;

        /**
         * 风控Key - 用户
         */
        public static final String USER_LIMIT_KEY = "user_limit:";

    }

    /**
     * redis key
     */
    public static class RedisKey {

        /**************************拦截相关**********************************/

        /**
         * user limit key
         */
        public static final String USER_LIMIT_KEY = "user_limit:";
        /**
         * ip limit key
         */
        public static final String IP_LIMIT_KEY = "ip_limit:";

        /**
         * 每个IP登录的用户数限制 key
         */
        public static final String IP_USER_LIMIT_KEY = "ip_user_limit:";

        /**
         * IP黑名单 key
         */
        public static final String BLACK_IP_KEY = "black_ip:";

        /**
         * 用户黑名单 key
         */
        public static final String BLACK_USER_KEY = "black_user:";

        /**
         * 登录过多lid的IP黑名单 key
         */
        public static final String TOO_MANY_USERS_BLACK_IP_KEY = "too_many_users_black_ip:";

        /**
         * 登录过多用户的用户拉黑时长
         */
        public static final String TOO_MANY_USERS_BLACK_USER = "too_many_users_black_user:";

        /**
         * 用户任务 Key
         */
        public static final String USER_TASK_KEY = "user_task:";

        /**
         * 黑名单过期时间, 30分钟
         */
        public static final int BLACK_KEY_TIME = 60 * 30;

//        public static final String _ = ":";

        /**************************活动相关**********************************/
        /**
         * 活动相关redis分区  dbindex：8
         */
        public static final String ACTIVITY_DBINDEX = "8";

        public static final String SESSION_KEY_OPENID = "sessionKey:openid_";
        public static final String SESSION_KEY_UNIONID = "sessionKey:unionid_";

        public static final String SERVICE_TOKEN_KEY = "token:";

        public static final String USER_KEY = "user:";
        public static final String USER_CARD_KEY = "user:card:";
        /**************************验证码相关**********************************/
        /**
         * SIGNKEY key
         */
        public static final String SIGNKEY_REDIS_KEY = "SIGNKEY_REDIS_KEY:";
        /**
         * 通用行为验证次数redis key
         */
        public static final String USER_CAPTCHA_CHECK_KEY = "user_captcha_ckeck:";
        /**
         * 用户行为验证码redis key
         */
        public static final String CAPTCHA_KEY = "user_captcha_key:";
        /**
         * 必购码行为验证次数redis key
         */
        public static final String BGM_CAPTCHA_CHECK_KEY = "bgm_captcha_ckeck:";
        /**
         * 必购码行为验证码redis key
         */
        public static final String BGM_CAPTCHA_KEY = "bgm_captcha:";

        /**
         * 兑吧活动相关
         */
        public static final String DUIBA_QRCODE_KEY = "duiba:qrCode:";
        public static final String DUIBA_ORDER_KEY = "duiba:orderNum:";
        public static final String DUIBA_GIFTTYPE_NAME = "duiba:giftType:name:";
        public static final String DUIBA_GIFT_CODE = "duiba:gift:code:";
        public static final String DUIBA_ADD_LEDOU_CODE = "duiba:addLedou:code:";
        public static final String DUIBA_ADD_VIRTUAL_PRIZE_CODE = "duiba:addVirtualPrize:code:";
        public static final String DUIBA_CONSUME_CODE = "duiba:consume:code:";

        /**
         * 兑吧活动接口每日频率限制
         */
        public static final String DUIBA_CALL_FRE_DAY_KEY = "duiba_call_fre_day:";

        /**
         * 微信用户formId(用于服务推送)
         */
        public static final String WECHAT_USER_FORMID = "wechat_formid:";
        public static final int WECHAT_USER_FORMID_TIME = 60 * 60 * 24 * 7;
        /**
         * 有效时间1个月
         */
        public static final int ONE_MONTH = 60 * 60 * 24 * 30;
        /**
         * 推送成功记录
         */
        public static final String WECHAT_PUSH_SUCCESS = "wechat_push_success:";
        public static final int WECHAT_PUSH_SUCCESS_TIME = 60 * 10;
        /**
         * 微信小程序公用token
         */
        public static final String WECHAT_ACCESS_TOKEN = "wechat_access_token";
        public static final int WECHAT_ACCESS_TOKEN_TIME = 5 * 60;
        /**
         * 用户签到
         */
        public static final String CHECKIN_ACTIVITY_USER_KEY = "checkin:activity:";
        public static final int CHECKIN_ACTIVITY_USER_KEY_TIME = 60 * 60 * 24 * 7;
        /**
         * 签到表
         */
        public static final String CHECKIN_KEY = "checkin_setting:";
        /**
         * 连续签到信息rediskey
         */
        public static final String USER_CHECKIN_STATE_KEY = "user_checkin_state:";

        /**
         * 签到历史信息rediskey
         */
        public static final String USER_CHECKIN_HISTORY_KEY = "user_checkin_history:";

        /**
         * 用户获取会员卡 加锁
         */
        public static final String USER_CARD_CODE_LOCAK = "user_code_wx_card_code";
        /**
         * 大转盘奖池
         */
        public static final String WHEELSETTING = "wheel_setting:";
        /**
         * 奖品类型
         */
        public static final String GIFT_TYPE_KEY = "gift_type:";
        /**
         * gift_type奖品类型黑金查询
         */
        public static final String GIFT_TYPE_CODE_KEY = "gift_type_code:";

        /**
         * gift_type奖品剩余库存
         */
        public static final String GIFT_TYPE_REMAINDER = "gift_type_remainder:";

//        /**
//         * 商品剩余库存
//         */
//        public static final String GOODS_REMAINING_STOCK = "goods_remaining_stock:";

        /**
         * 奖品类型
         */
        public static final String GIFT_TYPE = "gift_type:activity";

        public static final String BENEFIT_ITEM = "benefit_item:";

        public static final String BENEFIT_ITEM_QUEUE = "benefit_item_queue:";

        public static final String BENEFIT_DISPLAY_ITEM = "benefit_display_item:";

        /**
         * 素材key
         */
        public static final String MATERIAL = "material";
        /**
         * 活动
         */
        public static final String ActivityKey = "activity:";

        /**
         * 活动
         */
        public static final String Activity = "activity";
        /**
         * 用户初始化活动
         */
        public static final String USER_ACTIVITY_KEY = "user_activity:";
        /**
         * 剩余实物奖品数量
         */
        public static final String PHYSICAL_GIFT_LEFT = "physical_gift_left:";
        /**
         * 实物奖品总数量
         */
        public static final String PHYSICAL_GIFT_TOTAL = "physical_gift_total:";
        /**
         * 奖品总峰值
         */
        public static final String GIFT_TOTAL = "gift_total:";
        /**
         * 奖品每日峰值
         */
        public static final String GIFT_TODAY = "gift_today:";
        /**
         * 奖品每人中奖次数峰值
         */
        public static final String GIFT_USER = "gift_user:";
        /**
         * 用户抽奖风控
         */
        public static final String WHEEL_LOCK = "wheel_lock:";
        /**
         * 字典项Key
         */
        public static final String DICTIONARY_KEY = "dictionary:";
        /********************************************************/
        /**
         * 任务中心字典项缓存
         */

        /**
         * 任务Key
         */
        public static final String TASK_KEY_STR = "task";
        public static final String PRIZE_KEY = "prize";

        public static final String WARNING_KEY = "warning";

        public static final String REMIND_KEY = "remind";
        /********************************************************/
        /**
         * 公益任务ey
         */
        public static final String PUBLIC_SERVICE_ACTIVITY_KEY = "public_service_activity:";

        /**
         * 门店活动页面-字典项Key
         */
        public static final String ACTIVITY_PAGE_KEY = "activity:page:";

        /**
         * 门店活动栏位
         */
        public static final String ACTIVITY_FIELD_KEY = "activity:field:";

        /**
         * 门店活动明细
         */
        public static final String ACTIVITY_DETAILS_KEY = "activity:field_details:";

        /**
         * 门店活动券
         */
        public static final String ACTIVITY_COUPON_KEY = "activity:shop_coupon:";

        /**
         * 用户领取门店活动券
         */
        public static final String USER_ACTIVITY_COUPON_KEY = "activity:user_coupon:";

        /**
         * 用户领取门店活动券
         */
        public static final String ACTIVITY_COUPON_ID_KEY = "activity:shop_id_coupon:";

        /**
         * 门店活动券剩余
         */
        public static final String COUPON_REMAINING_QUANTITY = "activity:remaining_quantity:";

        /**
         * 门店活动店铺关系
         */
        public static final String COUPON_SHOP_RULE_KEY = "activity:coupon_shop_rule:";

        /**
         * 门店活动SN关系
         */
        public static final String COUPON_SN_RULE_KEY = "activity:coupon_sn_rule:";

        /**
         * 门店白名单
         */
        public static final String SHOP_USER_DUIBA_ACTIVITY_KEY = "activity:shop_user_duiba_activity:";
        /**
         * 门店白名单
         */
        public static final String SHOP_WHITELIST_RULE_KEY = "activity:shop_whitelist_rule:";


        /**
         * token key
         */
        public static final String TOKEN_KEY = "token:";

        /**
         * banner图的key
         */
        public static final String BANNER = "banner:";
        /**
         * banner_item图的key
         */
        public static final String BANNER_ITEM = "banner_item:";

        /**
         * category图的key
         */
        public static final String CATEGORY = "category:";

        /**
         * category_item图的key
         */
        public static final String CATEGORY_ITEM = "category_item:";
        /**
         * 弹窗key
         */
        public static final String BENEFIT_POPUP = "benefit_popup:";

        /**
         * 线下用户key
         */
        public static final String OWUSER_KEY = "owuser:";


        /**
         * 门店
         */
        public static final String SHOP = "shop:";


        /**
         * 门店名字
         */
        public static final String SHOP_NAME = "shopName";

        /**
         * shop_id
         */
        public static final String SHOP_ID = "shop_id:";

        /**
         * 抽奖活动图片配置
         */
        public static final String LOTTERY_SETTING = "lottery_setting:";

        /**************************会员身份相关**********************************/
        /**
         * 会员身份Key
         */
        public static final String USER_MEMBERSHIP = "user_membership:";

        /**************************黑金会员相关************************************/

        /**
         * 付费会员身份key
         */
        public static final String PAY_MEMBERSHIP = "pay_membership:";

        /**
         * 乐呗付费会员同步
         */
        public static final String SYNC_OMO_PAYMEMBER = "sync_omo_paymember:";
        /**
         * 黑金会员同步订单action
         */
        public static final String PAY_MEMBERSHIP_USER_ACTION = "pay_membership_user_action";

        /**
         * 黑金会员同步订单key
         */
        public static final String PAY_MEMBERSHIP_ORDER = "pay_membership_order_id:";

        /**************************one码相关************************************/
        /**
         * 用户已绑定one码key
         */
        public static final String USER_OPTION_CODE_KEY = "user_option_code:";

        /**
         * 选件会员码
         */
        public static final String OPTION_CODE_KEY = "option_code:";

        /**
         * 选件品类/物料
         */
        public static final String OPTION_CATEGORY_KEY = "option_category:";

        /**************************短信相关**********************************/
        /**
         * 短信验证码分钟频率限制key
         */
        public static final String SMS_FRE_MINUTE_KEY = "sms_fre_minute:";
        /**
         * 短信验证码分钟频率限制value
         */
        public static final String SMS_FRE_MINUTE_VALUE = "1";
        /**
         * 短信验证码分钟频率过期时间
         */
        public static final int SMS_FRE_MINUTE_EXPIRE_TIME = 60;
        /**
         * 短信验证码每日频率限制
         */
        public static final String SMS_FRE_DAY_KEY = "sms_fre_day:";
        /**
         * 用户短信验证码
         */
        public static final String SMS_CODE_KEY = "sms_code:";


        /**************************短信平台相关**********************************/
        /**
         * wso2 token key
         */
        public static final String WSO2TOKEN_KEY = "wso2TokenKey:";
        /**
         * wso2 token key的过期时间
         */
        public static final int WSO2TOKEN_KEY_EXPER_TIME = 60 * 9;

        /**
         * wso2 token key
         */
        public static final String WSO2TOKEN_KEY_TEST = "wso2TokenKeyTest:";


        /**
         * 微信用户unionid
         */
        public static final String WECHAT_UNIONID = "wechat_unionid";

        public static final String OPENID_UNIONID_KEY = "openid_unionid:";


        public static final String USER_PROFILE_KEY = "user_profile:";

        /**
         * token_time
         */
        public static final int TOKEN_KEY_TIME = 60 * 60 * 12;

        public static final int OPENID_UNIONID_KEY_TIME = 60 * 60 * 24 * 30;

        /**
         * redis失效时间设置为7天
         */
        public static final int LOSE_EFFICACY_TIME = 60 * 60 * 24 * 7;

        public static final int EXPIRE_TIME_FOR_THIRTY_MINUTES = 60 * 30;
        public static final int EXPIRE_TIME_FOR_ONE_DAY = 60 * 60 * 24;

        public static final int EXPIRE_TIME_FOR_ONE_HOUR = 60 * 60;

        /**
         * 签到活动分布式锁过期时间 5秒
         */
        public static final int TRY_LOCK_TIME = 5;
        /**************************分布式锁key**********************************/
        /**
         * 一机一码发放乐豆分布式锁
         */
        public static final String LOCK_SN_BONUS_LEDOU_JOB = "lock_sn_bonus_ledou_job";
        /**
         * 修改会员的生日及性别信息送乐豆
         */
        public static final String TRY_LOCK_KEY_UPDATE_USER_BIRTH_AND_GENDER = "lock_update_user_profile:";
        /**
         * 设备绑定
         */
        public static final String TRY_LOCK_KEY_DEVICE_BIND = "lock_device_bind:";
        /**
         * 兑换奖品
         */
        public static final String TRY_LOCK_KEY_EXCHANGE_GIFT = "lock_exchange_gift:";
        /**
         * 抽奖活动，抽奖列表redis key
         */
        public static final String DRAW_ACTIVITY_DRAW_LIST = "draw_activity_draw_list";
        /**
         * 必购码领取
         */
        public static final String TRY_LOCK_KEY_EXCHANGE_BGM = "lock_exchange_bgm:";

        /**************************membership（付费会员和等级会员）相关**********************************/
        /**
         * 会员信息字典项Key
         */
        public static final String USER_MEMBERSHIP_DICTIONARY_KEY = "user_membership_dictionary_key";
        /**
         * membership redisKey
         */
        public static final String USER_MEMBERSHIP_INFO = "api_user_membership_info:";

        /**
         * LIST_MEMBERSHIP_BY_ID  redisKey
         */
        public static final String LIST_MEMBERSHIP_BY_ID = "api_list_membership_by_id:";

        /**
         * LIST_MEMBERSHIP_BY_ID  redisKey
         */
        public static final String USER_MEMBERSHIP_AES_BODY = "api_user_membership_aes_body:";
        /**
         * MEMBERSHIP_FIND_BY_ID  redisKey
         */
        public static final String MEMBERSHIP_FIND_BY_ID = "api_membership_find_by_id:";

        /**
         * 黑金会员同步订单key  订单幂等
         */
        public static final String PAY_MEMBERSHIP_ORDER_ID = "pay_membership_order_id:";

        /**
         * 黑金超核排队列表
         */
        public static final String BLACK_GOLD_YGM_QUEUE_KEY = "black_gold_ygm_queue:";


        /**************************活动相关**********************************/
        /**
         * 奖品类型
         */
        public static final String VALID_GIFT_TYPE_KEY = "valid_gift_type:";

        /**
         * 表单提交活动
         */
        public static final String FORM_SUBMIT_ACTIVITY = "form_submit_activity:";
        /**
         * 任务中心活动
         */
        public static final String Task_User_Key = "task:activity:";

        /**
         * 任务中心未登录签到key
         */
        public static final String TASK_UNLOGIN_CHECKIN_KEY = "task_unlogin_checkin";
        /**
         * 签到配置列表 key
         */
        public static final String CHECK_IN_SETTING_LIST_KEY = "check_in_setting_list";
        /**
         * 任务中心未登录活动key
         */
        public static final String TASK_UNLOGIN_TASK_KEY = "task_unlogin_task:";

        /***************************任务中心*******************************************/

        /**
         * 任务中心未登录签到key
         */
        public static final String TASK_USER_GIFT_KEY = "task:gift:";
        /**
         * 配置奖品
         */
        public static final String TASK_SETTING_GIFT_TYPE_KEY = "task:setting_gift_type:";

        /**
         * 发放奖品
         */
        public static final String TASK_LOCK_KEY_EXCHANGE_GIFT = "task:lock_exchange_gift:";


        /**
         * 随机奖励累计幸运人数
         */
        public static final String LOCK_LUCKY_NUMBER = "task:lock_lucky_number:";

        /**
         * 用户发放奖品
         */
        public static final String TASK_LOCK_USER_TYPE_ID = "task:lock_user_type_id:";

        /**
         * 用户发放签到任务完成
         */
        public static final String TASK_CHECK_LOCK_USER_ID = "task:task_check_lock_user_id:";

        /**
         * 用户任务锁
         */
        public static final String LOCK_USER_TASK_ID = "task:lock_user_task_id:";

        /**
         * 配置任务奖品剩余量
         */
        public static final String GIFT_TYPE_SETTING = "task:gift_type_setting_remaining:";

        /**
         * 配置任务参与人数
         */
        public static final String GIFT_TYPE_PARTICIPATE_NUMBE = "task:gift_type_participate_numbe:";

        /**
         * 奖品详情
         */
        public static final String TASK_GIFT_TYPE_KEY = "task:gift_type:";


        /**
         * Goods库存
         */
        public static final String TASK_GOODS_KEY = "task:goods:";

        /**
         * 商品剩余库存
         */
        public static final String GOODS_REMAINING_STOCK = "task:goods_remaining_stock:";

        /**
         * 用户新领取优惠券数量
         */
        public static final String COUPON_NUM = "task:coupon_num:";

        /********************************************************************************/

        /**
         * 抽奖活动redis key
         */
        public static final String DRAW_ACTIVITY_TASK_KEY = "draw_activity:";
        /**
         * 抽奖活动可抽奖个数redis key
         */
        public static final String DRAW_ACTIVITY_ENABLE_LOTTERY_COUNT_KEY = "draw_activity_enable_lottery_count:";
        /**
         * 抽奖活动redis key
         */
        public static final String DRAW_USER_ACTIVITY_KEY = "draw_user_activity:";

        /**
         * 用户活动奖品
         */
        public static final String USER_GIFT_ACTIVITY_KEY = "user_gift_activity:";
        /**
         * 奖品剩余
         */
        public static final String GIFT_REMAINING = "gift_remaining:";
        /**
         * 乐树奖品兑奖公告
         */
        public static final String LESHU_GIFT_NOTICE = "leshu_gift_notice";
        /**
         * 奖品库存队列
         */
        public static final String GIFT_STORE_QUEUE = "gift_store_queue:";

        /**
         * 监测码
         */
        public static final String SHOP_MONITOR_CODE = "shop_monitor_code:";

        /**
         *
         */
        public static final String ENTRY_FORM_SHOP = "entry_form_shop:";

        /**
         * 首页弹窗key
         */
        public static final String BENEFIT_POPUP_HOME_KEY = "benefit_popup_home_key:";
        /**
         * 类型弹窗key
         */
        public static final String BENEFIT_POPUP_TYPE_KEY = "benefit_popup_type_key:";
        /**
         * 用户中奖信息key
         */
        public static final String USER_GIFT_KEY = "user_gift:";

        /**
         * 用户中奖信息key
         */
        public static final String USER_SHOP_GIFT_KEY = "user_shop_gift:";

        /**
         * 字典项Key
         */
        public static final String DICTIONARY_MODEL_TYPE_KEY = "dictionary_m_t:";
        /**
         * 公众号模板消息key
         */
        public static final String USER_TEMPLATE_MSG_KEY = "user_template_msg:";

        /**
         * 用户互动显示redis key
         */
        public static final String USER_TASK_NOTICE_KEY = "user_task_notice";
        /**
         * 任务Key
         */
        public static final String TASK_KEY = "task:";
        /**
         * 任务中心完成任务相关redis key
         */
        public static final String USER_TASK_CENTER_KEY = "user_task_center:";
        /**
         * 任务中心可用兑奖次数redis key
         */
        public static final String USER_LEDOU_EXCHANGE_KEY = "user_ledou_exchange:";
        /**
         * 用户行政区编码redis key
         */
        public static final String USER_ADCODE_KEY = "user_adcode_key:";
        /**
         * 任务中心乐树榜相关redis key
         */
        public static final String USER_TASK_LESHU_KEY = "user_task_leshu";
        /**
         * 任务类型Key
         */
        public static final String TASK_TYPE_KEY = "task_type:";
        /**
         * 会员权益Key
         */
        public static final String MEMBER_BENEFIT_KEY = "member_benefit:";
        /**
         * 栏位权益Key
         */
        public static final String MEMBER_BENEFIT_DISPLAY_KEY = "member_benefit_display:";
        /**
         * 个人会员权益Key
         */
        public static final String USER_MEMBER_BENEFIT_KEY = "user_member_benefit:";
        /**
         * 会员未登录权益Key
         */
        public static final String UN_MEMBER_BENEFIT_KEY = "un_member_benefit";
        /**
         * 付费会员价格
         */
        public static final String MEMBER_BENEFIT_PRICE_KEY = "price";
        /**
         * 个人会员权益Key
         */
        public static final String BENEFIT_KEY = "benefit:";

        /**
         * 我的必购码Key
         */
        public static final String MY_BENEFIT_BGM_KEY = "my_benefit_bgm:";
        /**
         * benefit必购码Key
         */
        public static final String BENEFIT_BGM_KEY = "benefit_bgm:";
        /**
         * 必购码-心仪机型
         */
        public static final String BGM_FAVORITE_MODEL_LIST = "bgm_favorite_model_list:";

        /**
         * 必购码-用户意向机型
         */
        public static final String BGM_USER_FAVORITE_MODEL = "bgm_user_favorite_model:";

        /**
         * 必购码总量  redisKey
         */
        public static final String BGM_GIFT_TOTAL = "bgm_gift_total:";

        /**
         * 必购码剩余
         */
        public static final String BGM_GIFT_REMAINING = "bgm_gift_remaining:";

        /**
         * 必购码删除剩余数量  redisKey
         */
        public static final String BGM_GIFT_DEL_REMAINING = "bgm_gift_del_remaining:";

        /**
         * 排队码剩余
         */
        public static final String PD_BGM_GIFT_REMAINING = "pd_bgm_gift_remaining:";

        /**************************会员身份相关**********************************/

        /**
         * 会员身份码表Key
         */
        public static final String MEMBERSHIP_INFO = "membership_info:";

        /**
         * 会员身份权益
         */
        public static final String USER_MEMBERSHIP_BENEFIT = "user_membership_benefit:";

        /**************************公益任务相关**********************************/

        /**
         * 战队Key
         */
        public static final String TEAM = "team:";

        /**
         * 公益任务-活动-战队关系Key
         */
        public static final String ACTIVITY_TEAM = "activity_team:";

        /**
         * 战队用户key
         */
        public static final String TEAM_USER = "team_user:";

        /**
         * 公益任务请求任务参数
         */
        public static final String USER_QRCODE_KEY = "user_qrCode:";
        /**
         * 公益任务请求任务参数
         */
        public static final String USER_REQUEST_PARAMS_KEY = "user_request_params:";
        /**
         * 用户分享公益任务token
         */
        public static final String USER_SHARE_TOKEN_KEY = "user_share_token:";

        /**************************用户设备相关**********************************/
        public static final String USER_DEVICE = "user_device:";
        /**
         * 服务延保信息
         */
        public static final String SERVICE_PRODUCT_INFO = "service_product_info:";
        /**
         * 服务-设备信息
         */
        public static final String SERVICE_DEVICE_INFO = "service_device_info:";
        /**
         * 服务-设备图片信息
         */
        public static final String SERVICE_DEVICE_PIC_INFO = "service_device_pic_info:";


        /**************************短信平台相关**********************************/

        /**
         * redis失效时间设置为1天
         */
        public static final int EXPIRE_TIME_FOR_DAY = 60 * 60 * 24;
        /**
         * redis失效时间设置为1个月
         */
        public static final int EXPIRE_TIME_FOR_MONTH = 60 * 60 * 24 * 30;
        /**
         * 黑名单过期时间, 5分钟
         */
        public static final int BLACK_KEY_TIME_FIVE = 60 * 5;


        /**************************分享配置相关**********************************/
        /**
         * 分享配置
         */
        public static final String SHARE_SETTING = "share_setting:";

        /**************************服务站相关**********************************/
        /**
         * api token
         */
        public static final String SERVICE_STATION_API_TOKEN = "service_station_api_token";
        /**
         * api token key的过期时间为一个半小时，默认时效为两小时
         */
        public static final int SERVICE_STATION_API_TOKEN_KEY_EXPIRE_TIME = 60 * 90;

        /**************************微信相关**********************************/
        /**
         * 公众号access token redis key
         */
        public static final String WECHAT_PUBLIC_ACCESS_TOKEN_REDIS_KEY = "wechat_public_access_token";
        /**
         * 公众号access token 过期时间（微信过期时间 2 小时）
         */
        public static final int WECHAT_PUBLIC_ACCESS_TOKEN_EXPIRE_TIME = 60 * 100;
        /**
         * 公众号jsapi ticket redis key
         */
        public static final String WECHAT_PUBLIC_JSAPI_TICKET_REDIS_KEY = "wechat_public_jsapi_ticket";
        /**
         * 公众号jsapi ticket 过期时间（微信过期时间 2 小时）
         */
        public static final int WECHAT_PUBLIC_JSAPI_TICKET_EXPIRE_TIME = 60 * 100;

        /**
         * 企业微信jsapi ticket redis key
         */
        public static final String WECOM_PUBLIC_JSAPI_TICKET_REDIS_KEY = "wecom_public_jsapi_ticket";
        /**
         * 企业微信jsapi ticket 过期时间（微信过期时间 2 小时）
         */
        public static final int WECOM_PUBLIC_JSAPI_TICKET_EXPIRE_TIME = 60 * 100;

        /**
         * 企业微信access token redis key
         */
        public static final String WECOM_PUBLIC_ACCESS_TOKEN_REDIS_KEY = "wecom_public_access_token";
        /**
         * 企业微信access token 过期时间（微信过期时间 2 小时）
         */
        public static final int WECOM_PUBLIC_ACCESS_TOKEN_EXPIRE_TIME = 60 * 100;
        /**
         * 企业微信access token redis key
         */
        public static final String WECOM_TXL_ACCESS_TOKEN_REDIS_KEY = "wecom_txl_access_token";
        /**
         * 企业微信access token 过期时间（微信过期时间 2 小时）
         */
        public static final int WECOM_TXL_ACCESS_TOKEN_EXPIRE_TIME = 60 * 100;


        /**
         * 用户福利兑换 redis key
         */
        public static final String USER_EXCHANGE_GIFT_KEY = "user_exchange_gift:";

        /**
         * 用户所领取的福利中心奖品 key
         */
        public static final String USER_GIFT_ALL_KEY = "user_gift_all:";

        /**
         * 活动中心配置 redisKey
         */
        public static final String ACTIVITY_CENTER_CONFIGURATION = "activity_center_configuration:";

        /**
         * 抵扣乐豆对外api
         */
        public static final String API_CONFIG_DEDUCTION_LEDOU = "api:config:deduction_ledou";

        /**
         * 抵扣乐豆对外api
         */
        public static final String API_CONFIG_RETURN_LEDOU = "api:config:return_ledou";

        /**
         * 微盟商户行为游标
         */
        public static final String WEIMOB_CUSTOMER_CURSORID = "weimob_customer_cursorid:";
        /**
         * 用户获取会员卡-微信
         */
        public static final String USER_CARD_CODE_WX = "user_card_code_wx";

        /**
         * 用户获取会员卡-付费会员
         */
        public static final String USER_CARD_CODE_PAY_MEMBER = "user_card_code_pay_member";

        /**************************分级会员**********************************/
        /**
         * 用户获成长值历史记录
         */
        public static final String GROWTH_VALUE_HISTORY_KEY = "growth_value_history_key:";
        /**
         * 成长值前十二个月个数（不包含当月）
         */
        public static final int MONTHS_COUNT = 13;

        /**
         * 对位api活动 增加成长值接口
         */
        public static final String API_ADD_USER_ACTIVE_VALUE = "api_add_user_active:";


        /**************************任务中台**********************************/

        /**
         * task
         */
        public static final String TASK_CENTER_TASK = "task_center:task:";

        /**
         * task
         */
        public static final String TASK_CENTER_USER_TASK_KEY = "task_center:user_task_key:";
        public static final String TASK_CENTER_CHANNEL_MEMBERSHIP_SETTING = "task_center:channel_membership_setting:";
        public static final String TASK_CENTER_GIFT_TYPE_CODE = "task_center:gift_type_code:";
        public static final String TASK_CENTER_SETTING_GIFT_TYPE_KEY = "task_center:setting_gift_type_key:";


        /************黑金续费*************/
        /**
         * 到期、续费提醒
         */
        public static final String EXPIRE_REMIND_USER_MEMBERSHIP = "expire_remind:user_membership:";
        /**
         * 今日是否要提醒
         */
        public static final String EXPIRE_REMIND_REMINDED_MEMBERSHIP = "expire_remind:reminded_membership:";

        /**
         * 用户奖品领取幂等性校验
         */
        public static final String USER_GIFT_EXCHANGE_CODE_KEY = "user_gift_exchange_code_key:";

        /**
         * 用户排队奖品幂等性校验
         */
        public static final String USER_QUEUE_EXCHANGE_KEY = "user_queue_exchange:";

    }

    /**
     * redis key
     */
    public static class EhCacheKey {

        /**************************秒杀存库相关**********************************/

        /**
         * 奖品已领完
         */
        public static final String GIFT_NUMBER_NOT_ENOUGH = "gift_number_not_enough:";
    }

    /**
     * membership信息字段
     */
    public static class MembershipType {

        public static final int LEVEL_PAY = 11;
        public static final int LEVEL_YOUXIANG = 21;
        public static final int LEVEL_ZUNXIANG = 22;


        public static final int USER_MEMBERSHIP_STATE_ACTIVATION = 1;//有效状态(0:否,1:是)
        public static final int USER_MEMBERSHIP_STATE_NOT_ACTIVATION = 0;//有效状态(0:否,1:是)

    }

    /**
     * 性别
     */
    public static class GenderType {
        /**
         * 男
         */
        public static final String MEN = "1";
        /**
         * 女
         */
        public static final String WOMEN = "2";
    }

    /**
     * 特殊符号校验
     */
    public static class Characters {

        public static final String characters = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
    }


    /**
     * 链接格式
     */
    public static class UrlFormat {

        /**
         * 内部H5
         */
        public static final Integer H5 = 1;
        /**
         * 内部小程序
         */
        public static final Integer APPLET = 6;
        /**
         * 外部H5
         */
        public static final Integer THIRD_H5 = 4;
        /**
         * 外部小程序
         */
        public static final Integer THIRD_APPLET = 2;
        /**
         * 官网H5
         */
        public static final Integer OFFICIAL_WEBSITE_H5 = 3;
    }
}














