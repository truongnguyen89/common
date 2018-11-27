package com.football.common.database;

import com.football.common.constant.Constant;
import com.football.common.model.common.PassThroughArray;
import com.football.common.util.DateCommon;
import com.football.common.util.StringCommon;
import com.jolbox.bonecp.ConnectionHandle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class ConnectionCommon {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CONNECTION);

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                LOGGER.error("Exception when closing connection: ", ex);
            }
        }
    }

    public static void close(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException ex) {
            LOGGER.error("Exception when closing CallableStatement: ", ex);
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            LOGGER.error("Exception when closing PreparedStatement: ", ex);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if (rset != null) {
                rset.close();
            }
        } catch (SQLException ex) {
            LOGGER.error("Exception when closing ResultSet: ", ex);
        }
    }

    public void closed(CallableStatement cs) {
        try {
            if (cs != null) {
                cs.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception when closing CallableStatement: ", e);
        }
    }

    public static void close(ResultSet rs, CallableStatement cs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception when closing ResultSet: ", e);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Exception when closing CallableStatement: ", e);
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception when closing ResultSet: ", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Exception when closing PreparedStatement: ", e);
            }
        }
    }

    public static void doSetStringParams(PreparedStatement ps, int index, String value) throws SQLException {
        if (value == null) {
            ps.setNull(index, java.sql.Types.VARCHAR);
        } else {
            ps.setString(index, value);
        }
    }

    public static void doSetStringParams(CallableStatement cs, int index, String value) throws SQLException {
        if (value == null) {
            cs.setNull(index, java.sql.Types.VARCHAR);
        } else {
            cs.setString(index, value);
        }
    }

    public static void doSetDateParams(PreparedStatement ps, int index, String value, String dateFormatPatterm) throws SQLException {
        if (StringCommon.isNullOrBlank(value)) {
            ps.setNull(index, java.sql.Types.DATE);
        } else {
            java.util.Date parsed = DateCommon.convertStringToDate(value, dateFormatPatterm);
            doSetDateParams(ps, index, parsed == null ? null : new java.sql.Date(parsed.getTime()));
        }
    }

    public static void doSetDateParams(CallableStatement cs, int index, String value, String dateFormatPatterm) throws SQLException {
        if (StringCommon.isNullOrBlank(value)) {
            cs.setNull(index, java.sql.Types.DATE);
        } else {
            java.util.Date parsed = DateCommon.convertStringToDate(value, dateFormatPatterm);
            doSetDateParams(cs, index, parsed == null ? null : new java.sql.Date(parsed.getTime()));
        }
    }

    public static void doSetDateParams(PreparedStatement ps, int index, java.sql.Date value) throws SQLException {
        if (value == null) {
            ps.setNull(index, java.sql.Types.DATE);
        } else {
            ps.setDate(index, value);
        }
    }

    public static void doSetDateParams(CallableStatement cs, int index, java.sql.Date value) throws SQLException {
        if (value == null) {
            cs.setNull(index, java.sql.Types.DATE);
        } else {
            cs.setDate(index, value);
        }
    }

    public static void doSetTimestampParams(PreparedStatement ps, int index, String value, String dateFormatPatterm) throws Exception {
        if (StringCommon.isNullOrBlank(value)) {
            ps.setNull(index, java.sql.Types.DATE);
        } else {
            Timestamp parsed = DateCommon.convertStringToTimestamp(value, dateFormatPatterm);
            doSetTimestampParams(ps, index, parsed);
        }
    }

    public static void doSetTimestampParams(PreparedStatement ps, int index, Timestamp value) throws SQLException {
        if (value == null) {
            ps.setNull(index, java.sql.Types.TIMESTAMP);
        } else {
            ps.setTimestamp(index, value);
        }
    }

    public static void doSetTimestampParams(CallableStatement cs, int index, String value, String dateFormatPatterm) throws Exception {
        if (StringCommon.isNullOrBlank(value)) {
            cs.setNull(index, java.sql.Types.DATE);
        } else {
            Timestamp parsed = DateCommon.convertStringToTimestamp(value, dateFormatPatterm);
            doSetTimestampParams(cs, index, parsed);
        }
    }

    public static void doSetTimestampParams(CallableStatement cs, int index, Timestamp value) throws SQLException {
        if (value == null) {
            cs.setNull(index, java.sql.Types.TIMESTAMP);
        } else {
            cs.setTimestamp(index, value);
        }
    }

    public static void doSetLongParams(PreparedStatement ps, int index, Long value) throws SQLException {
        if (value == null) {
            ps.setNull(index, java.sql.Types.INTEGER);
        } else {
            ps.setLong(index, value);
        }
    }

    public static void doSetLongParams(CallableStatement cs, int index, Long value) throws SQLException {
        if (value == null) {
            cs.setNull(index, java.sql.Types.INTEGER);
        } else {
            cs.setLong(index, value);
        }
    }

    public static void doSetIntParams(PreparedStatement ps, int index, Integer value) throws SQLException {
        if (value == null) {
            ps.setNull(index, java.sql.Types.INTEGER);
        } else {
            ps.setInt(index, value);
        }
    }

    public static void doSetIntParams(CallableStatement cs, int index, Integer value) throws SQLException {
        if (value == null) {
            cs.setNull(index, java.sql.Types.INTEGER);
        } else {
            cs.setInt(index, value);
        }
    }
}
