package com.nambv.android_tv_sample.util


import android.content.SharedPreferences

/**
 * helper for shared prefs - java version
 */

object PreferenceHelper {

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented.")
        }
    }

    inline fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float?: 0f) as T?
            Long::class -> getLong(key, defaultValue as? Long?: 0L) as T?
            else -> throw UnsupportedOperationException("Not yet implemented.")
        }
    }
}
//public class PreferenceHelper {
//
//    private PreferenceHelper() {}
//
//    public static <T> void setValue(Context context, String key, T value) {
//        if (value instanceof String) {
//            edit(context, (editor) -> editor.putString(key, (String) value));
//        } else if (value instanceof Boolean) {
//            edit(context, (editor) -> editor.putBoolean(key, (Boolean) value));
//        } else if (value instanceof Integer) {
//            edit(context, (editor) ->  editor.putInt(key, (Integer) value));
//        } else if (value instanceof Float) {
//            edit(context, (editor) ->  editor.putFloat(key, (Float) value));
//        } else {
//            throw new UnsupportedOperationException("Not yet implemented.");
//        }
//    }
//
//    public static <T> T getValue(Context context, String key, Class<?> aClass, T defaultValue) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        Object value;
//        if (aClass.equals(String.class)) {
//            value = sharedPreferences.getString(key, (String) defaultValue);
//        } else if (aClass.equals(Boolean.class)) {
//            value = sharedPreferences.getBoolean(key, (Boolean) defaultValue);
//        } else if (aClass.equals(Integer.class)) {
//            value = sharedPreferences.getInt(key, (Integer) defaultValue);
//        } else if (aClass.equals(Float.class)) {
//            value = sharedPreferences.getFloat(key, (Float) defaultValue);
//        } else {
//            throw new UnsupportedOperationException("Not yet implemented.");
//        }
//        return (T) value;
//    }
//
//    private static void edit(Context context, Performer<SharedPreferences.Editor> performer) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        performer.performOperation(editor);
//        editor.apply();
//    }
//
//    @FunctionalInterface
//    public interface Performer<T> {
//        void performOperation(T victim);
//    }
//}