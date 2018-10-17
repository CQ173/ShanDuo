package com.yapin.shanduo.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.yapin.shanduo.utils.Constants;

import java.util.Date;
import java.util.List;

/**
 * 作者：L on 2018/5/9 0009 18:32
 */
public class TrendInfo implements Parcelable {

    private int totalPage;

    private int page;

    private List<Trend> list;

    public int getTotalpage() {
        return totalPage;
    }

    public void setTotalpage(int totalpage) {
        this.totalPage = totalpage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Trend> getList() {
        return list;
    }

    public void setList(List<Trend> list) {
        this.list = list;
    }

    public static class Trend extends TrendInfo implements Parcelable {

        private int type = Constants.TYPE_SHOW;

        private String id;//动态ID
        private Integer userId;//用户ID
        private String name;//用户昵称
        private String portraitId;//头像
        private String age;//年龄
        private String content;//动态内容
        private List<String> picture;//动态图片或视频
        private Integer praise;//点赞人数
        private boolean isPraise;//是否点赞
        private String location;//位置
        private double distance;//距离
        private String remarks;//备注
        private long createDate;//发动态的时间
        private Integer vip;
        private String gender;//性别
        private double lon;
        private double lat;
        private Integer dynamicCount;
        private Integer level;

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public Integer getDynamicCount() {
            return dynamicCount;
        }

        public void setDynamicCount(Integer dynamicCount) {
            this.dynamicCount = dynamicCount;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPortraitId() {
            return portraitId;
        }

        public void setPortraitId(String portraitId) {
            this.portraitId = portraitId;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getPicture() {
            return picture;
        }

        public void setPicture(List<String> picture) {
            this.picture = picture;
        }

        public Integer getPraise() {
            return praise;
        }

        public void setPraise(Integer praise) {
            this.praise = praise;
        }

        public boolean isPraise() {
            return isPraise;
        }

        public void setPraise(boolean praise) {
            isPraise = praise;
        }


        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public Integer getVip() {
            return vip;
        }

        public void setVip(Integer vip) {
            this.vip = vip;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Trend() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.type);
            dest.writeString(this.id);
            dest.writeValue(this.userId);
            dest.writeString(this.name);
            dest.writeString(this.portraitId);
            dest.writeString(this.age);
            dest.writeString(this.content);
            dest.writeStringList(this.picture);
            dest.writeValue(this.praise);
            dest.writeByte(this.isPraise ? (byte) 1 : (byte) 0);
            dest.writeString(this.location);
            dest.writeDouble(this.distance);
            dest.writeString(this.remarks);
            dest.writeLong(this.createDate);
            dest.writeValue(this.vip);
            dest.writeString(this.gender);
            dest.writeDouble(this.lon);
            dest.writeDouble(this.lat);
            dest.writeValue(this.dynamicCount);
            dest.writeValue(this.level);
        }

        protected Trend(Parcel in) {
            this.type = in.readInt();
            this.id = in.readString();
            this.userId = (Integer) in.readValue(Integer.class.getClassLoader());
            this.name = in.readString();
            this.portraitId = in.readString();
            this.age = in.readString();
            this.content = in.readString();
            this.picture = in.createStringArrayList();
            this.praise = (Integer) in.readValue(Integer.class.getClassLoader());
            this.isPraise = in.readByte() != 0;
            this.location = in.readString();
            this.distance = in.readDouble();
            this.remarks = in.readString();
            this.createDate = in.readLong();
            this.vip = (Integer) in.readValue(Integer.class.getClassLoader());
            this.gender = in.readString();
            this.lon = in.readDouble();
            this.lat = in.readDouble();
            this.dynamicCount = (Integer) in.readValue(Integer.class.getClassLoader());
            this.level = (Integer) in.readValue(Integer.class.getClassLoader());
        }

        public static final Creator<Trend> CREATOR = new Creator<Trend>() {
            @Override
            public Trend createFromParcel(Parcel source) {
                return new Trend(source);
            }

            @Override
            public Trend[] newArray(int size) {
                return new Trend[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.totalPage);
        dest.writeInt(this.page);
        dest.writeTypedList(this.list);
    }

    public TrendInfo() {
    }

    protected TrendInfo(Parcel in) {
        this.totalPage = in.readInt();
        this.page = in.readInt();
        this.list = in.createTypedArrayList(Trend.CREATOR);
    }

    public static final Parcelable.Creator<TrendInfo> CREATOR = new Parcelable.Creator<TrendInfo>() {
        @Override
        public TrendInfo createFromParcel(Parcel source) {
            return new TrendInfo(source);
        }

        @Override
        public TrendInfo[] newArray(int size) {
            return new TrendInfo[size];
        }
    };
}
