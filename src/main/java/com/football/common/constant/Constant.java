package com.football.common.constant;

/*
 * Declare constants used in the project
 */
public interface Constant {
    //file config in lib_common
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
        public static final int ACTIVE = 1;
        public static final int LOCK = 2;
        public static final int INACTIVE = 0;
        public static final Long ACTIVE_LONG = 1L;
        public static final Long INACTIVE_LONG = 0L;
    }

    interface DATE {
        interface FORMAT {
            public static final String SHORT_DATE = "dd/MM/yyyy";
            public static final String FULL_DATE = "dd/MM/yyyy HH:mm:ss";
            public static final String MINUTE_TIME = "HH:mm";
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

            public static final String SYSTEM = "SYSTEM";
            public static final String EMAIL = "EMAIL";
            public static final String EMAIL_START_APPLICATION = "EMAIL_START_APPLICATION";
            public static final String GMAIL = "GMAIL";
            public static final String EXCEL = "EXCEL";
            public static final String EPAY_FINANCE = "EPAY_FINANCE";
            public static final String NOTIFICATION = "NOTIFICATION";
            public static final String ONE_SIGNAL = "ONE_SIGNAL";
            public static final String AGENT = "AGENT";
            public static final String API = "API";
            public static final String ROLES = "ROLE";
            public static final String USER = "USER";
            public static final String STADIUM = "STADIUM";
            public static final String SUB_STADIUM = "SUB_STADIUM";
            public static final String STADIUM_MANAGER = "STADIUM_MANAGER";
            public static final String BOOKING = "BOOKING";
            public static final String BOOKING_LOG = "BOOKING_LOG";
            public static final String MATCH_SCHEDULE = "MATCH_SCHEDULE";
            public static final String MATCH = "MATCH";
            public static final String LOG = "LOG";
            public static final String NOTIFICATION_CATEGORY = "NOTIFICATION_CATEGORY";
            public static final String NOTIFICATION_QUEUE = "NOTIFICATION_QUEUE";
            public static final String NOTIFICATION_LOG = "NOTIFICATION_LOG";
            public static final String ACCOUNT_APP_DEVICE = "ACCOUNT_APP_DEVICE";
            public static final String DEVICE = "DEVICE";
            public static final String APP = "APP";
            public static final String OPEN_WEATHER = "OPEN_WEATHER";
        }

        interface CODE {

            public static final String TYPE = "TYPE";
            public static final String STATUS = "STATUS";
            public static final String STATUS_ACTIVE = "STATUS_ACTIVE";
            public static final String STATUS_INACTIVE = "STATUS_INACTIVE";
            public static final String STATUS_LOCK = "STATUS_LOCK";
            public static final String STATUS_NEW = "STATUS_NEW";
            public static final String STATUS_MANAGER_AGREE = "STATUS_MANAGER_AGREE";
            public static final String STATUS_CANCEL = "STATUS_CANCEL";
            public static final String STATUS_MANAGER_REFUSE = "STATUS_MANAGER_REFUSE";
            public static final String ACCOUNT = "ACCOUNT";
            public static final String PASS = "PASS";
            public static final String HOST = "HOST";
            public static final String PORT = "PORT";
            public static final String SUBJECT = "SUBJECT";
            public static final String MESSAGE = "MESSAGE";
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
            public static final String API_KEY = "API_KEY";
            public static final String ROWNUM = "ROWNUM";
            public static final String NUMBER_THREAD_SEND_NOTIFICATION = "NUMBER_THREAD_SEND_NOTIFICATION";
            public static final String NUMBER_THREAD_SEND_EMAIL = "NUMBER_THREAD_SEND_EMAIL";
            public static final String FROM_MAIL_DEFAUL = "FROM_MAIL_DEFAUL";
            public static final String EMAIL_ACCOUNT = "EMAIL_ACCOUNT";
            public static final String EMAIL_FROM = "EMAIL_FROM";
            public static final String EMAIL_HOST = "EMAIL_HOST";
            public static final String EMAIL_PASS = "EMAIL_PASS";
            public static final String EMAIL_PORT = "EMAIL_PORT";
            public static final String IMPORT_DATA_WEATHER_LOCAL_TEST = "IMPORT_DATA_WEATHER_LOCAL_TEST";
            public static final String IMPORT_DATA_AREA_TEST = "IMPORT_DATA_AREA_TEST";
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
        public static final String ROLE = "role";
        public static final String TOKEN = "token";
        public static final String USER = "user";
        public static final String STADIUM = "stadium";
        public static final String SUB_STADIUM = "sub_stadium";
        public static final String STADIUM_MANAGER = "stadium_manager";
        public static final String BOOKING = "booking";
        public static final String BOOKING_LOG = "booking_log";
        public static final String MATCH_SCHEDULE = "match_schedule";
        public static final String MATCH = "match";
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
        public static final String CITY_PROVINCIAL = "city_provincial";
        public static final String COUNTY_DISTRICT = "county_district";
        public static final String COMMUNE = "commune";
        public static final String AREA = "area";
        public static final String WEATHER_LOCAL = "weather_local";
        public static final String WEATHER_INFO = "weather_info";
    }

    //Declare FUNCTIONS used in the DATABASE
    interface FUNCTIONS {

        public static final String GET_MANAGER_BY_MATCH = "{? = call get_manager_by_match( ?)}";
    }

    //Declare PROCEDURES used in the DATABASE
    interface PROCEDURES {

        public static final String GET_PC_INFO = "{? = call get_pc_info( ?, ? , ?)}";
        public static final String GET_PC_CODE_AND_REGION_ID = "{call get_pc_code_and_region_id( ?, ? , ?, ?)}";
    }

    interface FEIGN_CLIENT {
        public static final String SERVICE_CATEGORY = "category";
        public static final String SERVICE_DATABASE = "database";
        public static final String SERVICE_FINANCE = "finance";
        public static final String ECPAY_SCHEDULER = "scheduler";
        public static final String SERVICE_NOTIFICATION = "notification";

    }

    interface STATUS_BILL {

        public static final int ERR = -1;
        public static final int UNPAID = 0;
        public static final int PAID = 1;
        public static final int OFFLINE = 2;
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
            public static final int ERROR = 2;
            public static final int WAIT = 3;
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

    interface DEVICE {
        interface STATUS {
            public static final int OFFLINE = 2;
            public static final int ONLINE = 1;
            public static final int INACTIVE = 0;
        }
    }

    interface MATCH {
        interface STATUS {
            public static final int FREE = 1;
            public static final int WAITING_CONFIRM = 2;
            public static final int BOOKED = 3;
            public static final int INACTIVE = 0;
        }
    }

    interface BOOKING {
        interface STATUS {
            public static final int NEW = 1;
            public static final int WAITING_CONFIRM = 2;
            public static final int BOOKED = 3;
            public static final int CANCEL = 4;
            public static final int REFUSE = 5;
            public static final int REJECT = 6;
        }
    }

    interface USER {
        interface TYPE {
            public static final int ADMIN = 1;
            public static final int PLAYER = 2;
            public static final int MANAGER = 3;
        }
    }

    interface AREA {
        interface LEVEL {
            public static final int CITY = 1; //Tinh, TP
            public static final int DISTRICT = 2; //Quan, huyen
            public static final int COMMUNE = 3; //Phuong xa
        }
    }

    interface SYSTEM {
        interface IMPORT_DATA_WEATHER_LOCAL_TEST {
            public static final int NO = 1; //Chua duoc import
            public static final int DOING = 2; //Dang import
            public static final int YES = 3; //Da import
        }

        interface IMPORT_DATA_AREA_TEST {
            public static final int NO = 1; //Chua duoc import
            public static final int DOING = 2; //Dang import
            public static final int YES = 3; //Da import
        }
    }

    interface RESOURCE {
        interface KEY {

            public static final String NOT_AVAILABLE = "param1.is.not.available";
            public static final String IS_NULL = "param1.is.null";
            public static final String IS_EXISTS = "param1.is.exists";
            public static final String NOT_FOUND = "param1.not.found";
            public static final String INACTIVE = "param1.inactive";
            public static final String INVALID = "param1.invalid";

            public static final String NOT_AVAILABLE_FIELD_OF_OBJECT = "param1.of.param2.is.not.available";
            public static final String IS_NULL_FIELD_OF_OBJECT = "param1.of.param2.is.null";
            public static final String IS_EXISTS_FIELD_OF_OBJECT = "param1.of.param2.is.exists";
            public static final String NOT_FOUND_FIELD_OF_OBJECT = "param1.of.param2.not.found";
            public static final String INACTIVE_FIELD_OF_OBJECT = "param1.of.param2.inactive";
            public static final String INVALID_FIELD_OF_OBJECT = "param1.of.param2.invalid";
        }
    }

}
