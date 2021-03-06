package io.polytech.sportable.persistence;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import io.polytech.sportable.models.practice.PracticeType;

@Entity
public class PracticeResult {

    @PrimaryKey
    @ColumnInfo(name = "date")
    public final long date;

    @ColumnInfo(name = "distance")
    public final float distance;

    @ColumnInfo(name = "calories")
    public final float calories;

    @ColumnInfo(name = "time")
    public final long time;

    @TypeConverters({PracticeTypeConverter.class})
    @ColumnInfo(name = "practiceType")
    public final PracticeType practiceType;

    public PracticeResult(long date, float distance, float calories, long time, PracticeType practiceType) {
        this.date = date;
        this.distance = distance;
        this.calories = calories;
        this.time = time;
        this.practiceType = practiceType;
        //date = System.currentTimeMillis();
    }

    public String getTime() {
        return String.format("%s:%s:%s", time / 3600000, time / 60000, time / 1000);
    }
}

