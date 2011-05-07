package com.pufff.quartz

import com.pufff.domain.user.Alerta

/**
 * Created by IntelliJ IDEA.
 * User: mario
 * Date: 7/05/11
 * Time: 20:55
 * To change this template use File | Settings | File Templates.
 */
class CronExpression {

    int second = 0
    int minute
    int hour
    String dayOfMonth = '*'
    String month = '*'
    String dayOfWeek


    public String value() {
        return "${second} ${minute} ${hour} ${dayOfMonth} ${month} ${dayOfWeek}"
    }

}
