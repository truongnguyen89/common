package com.football.common.constant;

/*
 * Declare constants used in the project
 */
public interface Constant {
    //file config in lib_common
    public static final String FILE_CONFIG = "config_common.properties";
    public static final String UTF_8 = "UTF-8";
    public static final String EMPTY = "";

    interface AGENT {
        public static final String ADMIN = "ADMIN";
    }

    interface HEADER {
        public static final String PASSWORD = "password";
        public static final String AGENT = "agent";

        interface ATTRIBUTE {
            public static final String START_TIME = "startTime";
        }
    }

    interface BODY {

        interface ATTRIBUTE {
            public static final String RESPONSE_CODE = "responseCode";
            public static final String DESCRIPTION = "description";
            public static final String STATUS = "status";
            public static final String MESSAGE = "message";
        }
    }

    interface KEY {
        public static final String PROVIDER_CODE = "providerCode";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String ADDRESS = "address";
        public static final String PHONE = "phone";
        public static final String ID_NO = "idNo";
        public static final String STATUS = "status";
        public static final String TYPE = "type";
        public static final String EDONG = "edong";
        public static final String AUDIT_NUMBER = "auditNumber";
        public static final String REQUEST_METHOD = "requestMethod";
        public static final String EXCEPTION = "exception";
        public static final String ID = "id";
        public static final String SORT_COLUMN = "sortColumn";
        public static final String SORT_ORDER = "sortOrder";
        public static final String PAGE = "page";
        public static final String SIZE = "size";
        public static final String ACCOUNT = "account";

    }

    interface CRYPT {
        interface MD5 {
            public static final String ALGORITHM = "MD5";
            public static byte[] HEX_ARRAY = new byte[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        }
    }

    //Count milliseconds
    interface INTERVAL {

        public static final long DAY = 1000 * 60 * 60 * 24;
        public static final long HOUR = 1000 * 60 * 60;
        public static final long MINUS = 1000 * 60;
        public static final long SECOND = 1000;
    }

    interface STATUS_OBJECT {

        public static final String ACTIVE_STRING = "1";
        public static final String INACTIVE_STRING = "0";
        public static final int ACTIVE_INT = 1;
        public static final int INACTIVE_INT = 0;
        public static final Long ACTIVE = 1L;
        public static final Long INACTIVE = 0L;
    }

    interface DATE {
        interface FORMAT {
            public static final String SHORT_DATE = "dd/MM/yyyy";
            public static final String FULL_DATE = "dd/MM/yyyy HH:mm:ss";
            public static final String FULL_DATE_SSS = "dd/MM/yyyy HH:mm:ss.SSS";
            public static final String TIME_STAMP = "yyyyMMddHHmmssSSS";
            public static final String TERM_DATE = "MM/yyyy";
            public static final String EPAY_DATE = "yyyy-MM-dd";
            public static final String EPAY_FULL_DATE = "yyyy-MM-dd HH:mm:ss";
        }
    }


    interface JSON_FIELDS {

        interface FOOTER {

            public static final String NAME = "footer";
        }
    }


    interface ACCOUNT {
        public static final String DEFAULT_VALUE = "0912345678";
    }

    interface PARAMS {

        interface TYPE {

            public static final String EMAIL = "EMAIL";
            public static final String EXCEL = "EXCEL";
            public static final String EPAY_FINANCE = "EPAY_FINANCE";
            public static final String NOTIFICATION = "NOTIFICATION";
            public static final String ONE_SIGNAL = "ONE_SIGNAL";
        }

        interface CODE {

            public static final String ACCOUNT = "ACCOUNT";
            public static final String PASS = "PASS";
            public static final String HOST = "HOST";
            public static final String PORT = "PORT";
            public static final String TO_MAIL_DEFAUL = "TO_MAIL_DEFAUL";
            public static final String ROWNUM_IN_SHEET = "ROWNUM_IN_SHEET";
            public static final String CLIENT_ID = "CLIENT_ID";
            public static final String URL = "URL";
            public static final String TIME_OUT = "TIME_OUT";
            public static final String CONNECTION_TIME_OUT = "CONNECTION_TIME_OUT";
            public static final String PUBLIC_KEY = "PUBLIC_KEY";
            public static final String PRIVATE_KEY = "PRIVATE_KEY";
            public static final String OPERATION_SEARCH = "OPERATION_SEARCH";
            public static final String URL_PARAM_SEARCH = "URL_PARAM_SEARCH";
            public static final String REST_API_KEY = "REST_API_KEY";
            public static final String ROWNUM = "ROWNUM";
            public static final String NUMBER_THREAD_SEND_NOTIFICATION = "NUMBER_THREAD_SEND_NOTIFICATION";
            public static final String NUMBER_THREAD_SEND_EMAIL = "NUMBER_THREAD_SEND_EMAIL";
            public static final String FROM_MAIL_DEFAUL = "FROM_MAIL_DEFAUL";
            public static final String EMAIL_ACCOUNT = "EMAIL_ACCOUNT";
            public static final String EMAIL_FROM = "EMAIL_FROM";
            public static final String EMAIL_HOST = "EMAIL_HOST";
            public static final String EMAIL_PASS = "EMAIL_PASS";
            public static final String EMAIL_PORT = "EMAIL_PORT";
        }

        interface VALUE {

            public static final String EVN = "EVN";
        }
    }

    interface LOG_APPENDER {
        public static final String APPLICATION = "application";
        public static final String COMMON = "common";
        public static final String EMAIL = "email";
        public static final String CONNECTION = "connection";
        public static final String CATEGORY = "category";
        public static final String AUTHENTICATION = "authentication";
        public static final String EPAY = "epay";
        public static final String DB = "db";
        public static final String CUSTOMER = "customer";
        public static final String BILL = "bill";
        public static final String CORE = "core";
        public static final String BILLING = "billing";
        public static final String NOTIFICATION = "notification";
        public static final String ONESIGNAL = "onesignal";

        interface STATUS {
            public static final String SUCCESS = "SUCCESS";
            public static final String EXCEPTION = "EXCEPTION";
        }
    }

    interface PAGE {
        interface DEFAULT_VALUE {
            public static final String SORT_ORDER = "ASC";
            public static final String ASC_ORDER = "ASC";
            public static final String DESC_ORDER = "DESC";
            public static final String PAGE = "0";
            public static final int PAGE_INT = 0;
            public static final String SIZE = "100";
            public static final int SIZE_INT = 100;
        }
    }


    interface MESSAGE {

        interface HEADER {

            public static final String OBJECT_CUSTOMER = "CUSTOMER";
            public static final String OBJECT_BILL = "BILL";
        }
    }

    interface OBJECT {
        public static final String PASSWORD = "password";
    }

    //Declare TABLE used in the DATABASE
    interface TABLE {
        public static final String PARAM = "params";
        public static final String AGENT = "agent";
        public static final String API = "api";
        public static final String ROLES = "roles";
        public static final String USER = "user";
        public static final String STADIUM = "stadium";
        public static final String SUB_STADIUM = "sub_stadium";
        public static final String STADIUM_MANAGER = "stadium_manager";
        public static final String BOOKING = "booking";
        public static final String BOOKING_LOG = "booking_log";
        public static final String LOG = "log";
        public static final String NOTIFICATION_CATEGORY = "notification_category";
        public static final String NOTIFICATION = "notification";
        public static final String NOTIFICATION_QUEUE = "notification_queue";
        public static final String NOTIFICATION_LOG = "notification_log";
        public static final String ACCOUNT_APP_DEVICE = "account_app_device";
        public static final String DEVICE = "device";
        public static final String APP = "app";
        public static final String EMAIL = "email";
        public static final String ACCOUNT = "account";
    }

    //Declare SEQUENCE used in the DATABASE
    interface SEQUENCE {
        public static final String SQ_AGENT = "sq_agent";
        public static final String SQ_API = "sq_api";
        public static final String SQ_ROLES = "sq_roles";
        public static final String SQ_LOG = "sq_log";
        public static final String SQ_NOTIFICATION_QUEUE = "sq_notification_queue";
        public static final String SQ_NOTIFICATION_LOG = "sq_notification_log";
        public static final String SQ_NOTIFICATION = "sq_notification";
        public static final String SQ_DEVICE = "sq_device";
        public static final String SQ_APP = "sq_app";
        public static final String SQ_EMAIL = "sq_email";
        public static final String SQ_ACCOUNT_APP_DEVICE = "sq_account_app_device";
        public static final String SQ_ACCOUNT = "sq_account";
    }

    //Declare schema used in the DATABASE
    interface SCHEMA {
        public static final String ESTORE = "estore";
        public static final String ECPAY_LOG = "ecpay_log";
        public static final String ENOTIFICATION = "enotification";
    }

    //Declare PACKAGE used in the DATABASE
    interface PACKAGE {
        interface PKG_ESTORE_VALIDATE {

            public static final String PRO_CHECK_TRANS = "{call pkg_estore_validate.check_trans (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            public static final String FCN_CHECK_LOGIN = "{? = call pkg_estore_validate.check_login (?, ?, ?, ?, ?, ?)}";
        }
    }

    interface PKG_ESTORE_COMMON {

        public static final String FCN_GET_PARAMS = "{? = call pkg_estore_common.get_params( ?, ?, ?, ?)}";
    }

    interface PKG_ESTORE_FINANCE {

        public static final String PRO_MERGE_CUSTOMER = "{call pkg_estore_finance.merge_customer (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        public static final String FCN_GET_LIST_CUSTOMER = "{? = call pkg_estore_finance.get_list_customer (?, ?, ?, ?, ?, ?, ?)}";
    }

    //Declare PACKAGE used in the DATABASE eNotification
    interface PKG_ENOTIFICATION_NOTIFICATION {

        public static final String PRO_SAVE_NOTIFICATION_QUEUE = "{call pkg_enotification_notification.save_notification_queue (?, ?, ?, ?, ?)}";
        public static final String FCN_GET_NOTIFICATION_QUEUE_TO_SEND = "{? = call pkg_enotification_notification.get_notification_queue_to_send (?)}";
        public static final String FCN_GET_NOTIFICATION_BY_EDONG = "{? = call pkg_enotification_notification.get_notification_by_edong (?,?,?)}";
        public static final String FCN_GET_NOTIFY_BY_EDONG_GET_PAGE = "{? = call pkg_enotification_notification.get_notify_by_edong_get_page (?,?,?,?)}";
        public static final String FCN_UPDATE_ACCOUNT_APP_DIVCE = "{call pkg_enotification_notification.update_account_app_device (?,?,?,?,?,?)}";
        public static final String FCN_UPDATE_NOTIFICATION_QUEUE = "{call pkg_enotification_notification.update_notification_queue (?,?,?,?)}";

    }

    interface PKG_ENOTIFICATION_LOGIN {

        public static final String PRO_LOGOUT_EDONG_DEVICE_OTHER = "{call pkg_enotification_login.logout_edong_device_other (?, ?, ?, ?)}";
    }

    //Declare FUNCTIONS used in the DATABASE
    interface FUNCTIONS {

        public static final String GET_REGION_ID = "{? = call get_region_id( ?)}";
    }

    //Declare PROCEDURES used in the DATABASE
    interface PROCEDURES {

        public static final String GET_PC_INFO = "{? = call get_pc_info( ?, ? , ?)}";
        public static final String GET_PC_CODE_AND_REGION_ID = "{call get_pc_code_and_region_id( ?, ? , ?, ?)}";
    }

    interface FEIGN_CLIENT {
        public static final String SERVICE_DATABASE = "ecpay-database";
        public static final String SERVICE_FINANCE = "ecpay-finance";
        public static final String ECPAY_SCHEDULER = "ecpay-scheduler";
        public static final String SERVICE_NOTIFICATION = "ecpay-notification";

    }

    interface EPAY {
        public static final String CLIENT_ID = "ClientId";
        public static final String REQUEST_DATA = "RequestData";
        public static final String REQUEST_TIME = "RequestTime";
        public static final String SIGNATURE = "Signature";
        public static final String OPERATION = "Operation";
        public static final String FINANCIAL_CODE = "FinancialCode";
        public static final String CONTRACT_NO = "ContractNo";
        public static final String ID_NO = "IdNo";
        public static final String RESPONSE_OK = "0";
    }

    interface STATUS_BILL {

        public static final int ERR = -1;
        public static final int UNPAID = 0;
        public static final int PAID = 1;
        public static final int OFFLINE = 2;
    }

    interface BRIDGE {
        public static final String EPAY_FINANCE = "EPAY_FINANCE";
        public static final String VIETTEL_PAY = "VIETTEL_PAY";
    }

    interface NOTIFICATION {
        interface TYPE {
            public static final int NORMAL = 1;
        }
    }

    interface NOTIFICATION_QUEUE {
        interface STATUS {
            public static final int NEW = 0;
            public static final int SENT = 1;
            public static final int ERROR = -1;
        }
    }

    interface ONE_SIGNAL {
        interface KEY {
            public static final String APP_ID = "app_id";
            public static final String INCLUDED_SEGMENTS = "included_segments";
            public static final String INCLUDE_PLAYER_IDS = "include_player_ids";
            public static final String DATA = "data";
            public static final String CONTENTS = "contents";
            public static final String RECIPIENTS = "recipients";
            public static final String ERRORS = "errors";
        }
    }

    interface EMAIL {
        interface STATUS {
            public static final int NEW = 0;
            public static final int SENT = 1;
            public static final int ERROR = -1;
        }
    }
}
