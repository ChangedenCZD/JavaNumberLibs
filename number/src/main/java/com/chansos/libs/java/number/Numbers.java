package com.chansos.libs.java.number;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 数字类工具库
 *
 * @author Changeden
 * @since 2018年4月9日
 */
public final class Numbers {

    /**
     * 生成一个整数范围对象
     * 默认:
     * 从0开始;
     * 步长位1;
     * 如果最后一位与结束位置不同，忽略追加;
     *
     * @param end 结束位置（包含本身）
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> range(int end) {
        return range(0, end);
    }

    /**
     * 生成一个整数范围对象
     * 默认:
     * 步长位1;
     * 如果最后一位与结束位置不同，忽略追加;
     *
     * @param start 起始位置（包含本身）
     * @param end   结束位置（包含本身）
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> range(int start, int end) {
        return range(start, end, 1);
    }

    /**
     * 生成一个整数范围对象
     * 默认:
     * 如果最后一位与结束位置不同，忽略追加;
     *
     * @param start 起始位置（包含本身）
     * @param end   结束位置（包含本身）
     * @param step  步长
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> range(int start, int end, int step) {
        return range(start, end, step, true);
    }

    /**
     * 生成一个整数范围对象
     *
     * @param start     起始位置（包含本身）
     * @param end       结束位置（包含本身）
     * @param step      步长
     * @param ignoreEnd 如果最后一位与结束位置不同，是否忽略追加
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> range(int start, int end, int step, boolean ignoreEnd) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i += step) {
            list.add(i);
        }
        if (!(list.contains(end) || ignoreEnd)) {
            list.add(end);
        }
        return list;
    }

    /**
     * 生成一个长度位size，用0占位的对象
     *
     * @param size 长度
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> zero(int size) {
        return initialize(size, 0);
    }

    /**
     * 生成一个长度位size，用defaultValue占位的对象
     *
     * @param size         长度
     * @param defaultValue 默认占位
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> initialize(int size, int defaultValue) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(defaultValue);
        }
        return list;
    }

    /**
     * 生成一个整数范围对象
     * 默认:
     * 从0开始;
     * 步长位1;
     * 如果最后一位与结束位置不同，忽略追加;
     *
     * @param end 结束位置（包含本身）
     * @return ForEachObject
     * @see ForEachObject
     */
    public static ForEachObject rangeObject(int end) {
        return rangeObject(0, end);
    }

    /**
     * 生成一个整数范围对象
     * 默认:
     * 步长位1;
     * 如果最后一位与结束位置不同，忽略追加;
     *
     * @param start 起始位置（包含本身）
     * @param end   结束位置（包含本身）
     * @return ForEachObject
     * @see ForEachObject
     */
    public static ForEachObject rangeObject(int start, int end) {
        return rangeObject(start, end, 1);
    }

    /**
     * 生成一个整数范围对象
     * 默认:
     * 如果最后一位与结束位置不同，忽略追加;
     *
     * @param start 起始位置（包含本身）
     * @param end   结束位置（包含本身）
     * @param step  步长
     * @return ForEachObject
     * @see ForEachObject
     */
    public static ForEachObject rangeObject(int start, int end, int step) {
        return rangeObject(start, end, step, true);
    }

    /**
     * 生成一个整数范围对象
     *
     * @param start     起始位置（包含本身）
     * @param end       结束位置（包含本身）
     * @param step      步长
     * @param ignoreEnd 如果最后一位与结束位置不同，是否忽略追加
     * @return ForEachObject
     * @see ForEachObject
     */
    public static ForEachObject rangeObject(int start, int end, int step, boolean ignoreEnd) {
        ArrayList<Integer> list = range(start, end, step, ignoreEnd);
        return new ForEachObject<List<Integer>>(list);
    }

    /**
     * 生成一个长度位size，用0占位的对象
     *
     * @param size 长度
     * @return ForEachObject
     * @see ForEachObject
     */
    public static ForEachObject zeroObject(int size) {
        return initializeObject(size, 0);
    }

    /**
     * 生成一个长度位size，用defaultValue占位的对象
     *
     * @param size         长度
     * @param defaultValue 默认占位
     * @return ForEachObject
     * @see ForEachObject
     */
    public static ForEachObject initializeObject(int size, int defaultValue) {
        ArrayList<Integer> list = initialize(size, defaultValue);
        return new ForEachObject<List<Integer>>(list);
    }

    /**
     * 将字符串转换成数字
     *
     * @param string 字符串
     */
    public static int stringToNumber(String string) {
        int number = 0;
        int length = string.length();
        for (int i = 0; i < length; i++) {
            int charCode = (int) string.charAt(i);
            number += charCode;
        }
        return number;
    }

    /**
     * 生成随机整数
     */
    public static int random() {
        return random(0, Integer.MAX_VALUE);
    }

    /**
     * 生成一定范围内的随机整数
     *
     * @param minValue 最小值（包含）
     * @param maxValue 最大值（包含）
     */
    public static int random(int minValue, int maxValue) {
        float seed = stringToNumber(UUID.randomUUID().toString());
        double random = Math.random() * (System.currentTimeMillis() % seed);
        float result = (int) (random * seed);
        if (result > maxValue) {
            result = result % (maxValue - minValue);
        }
        if (result < minValue) {
            result = Math.min(result + minValue, maxValue);
        }
        return (int) result;
    }

    /**
     * 将文件大小转换成带单位的格式
     *
     * @param length 文件大小
     * @return FileSize
     * @see FileSize
     */
    public static FileSize parseFileSize(long length) {
        return parseFileSize(new FileSize(length));
    }

    /**
     * 将文件大小转换成带单位的格式
     *
     * @param fileSize 文件大小信息的封装
     * @return FileSize
     * @see FileSize
     */
    private static FileSize parseFileSize(FileSize fileSize) {
        float MAX = 1024f;
        FileSize.Information information = fileSize.getInformation();
        double length = information.getLength();
        String unit = information.getUnit();
        String nextUnit = unit;
        double Isopsephy = length / MAX;
        boolean canIsopsephy = (int) Isopsephy > 0;
        if (canIsopsephy) {
            switch (unit) {
                case "B":
                    nextUnit = "KB";
                    break;
                case "KB":
                    nextUnit = "MB";
                    break;
                case "MB":
                    nextUnit = "GB";
                    break;
                case "GB":
                    nextUnit = "TB";
                    break;
                default:
                    nextUnit = unit;
                    break;
            }
        }
        information.setUnit(nextUnit);
        if (Isopsephy > MAX && !"TB".equals(nextUnit)) {
            information.setLength(Isopsephy);
            return parseFileSize(fileSize);
        } else {
            if (Isopsephy < 1) {
                Isopsephy = length;
            }
            information.setLength(Isopsephy);
            return fileSize;
        }
    }
}
