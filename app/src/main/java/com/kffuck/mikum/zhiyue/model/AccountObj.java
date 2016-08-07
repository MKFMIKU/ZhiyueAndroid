package com.kffuck.mikum.zhiyue.model;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AccountObj {

    private static final String ACCOUNT = "ACCOUNT";


    public static void saveAccount(Context context, UserObj user) throws FileNotFoundException {
        File file = new File(context.getFilesDir(), ACCOUNT);
        if (file.exists()) {
            file.delete();
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(ACCOUNT, Context.MODE_PRIVATE));
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserObj loadAccount(Context context) {
        UserObj user = null;
        File file = new File(context.getFilesDir(), ACCOUNT);
        if (file.exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(context.openFileInput(ACCOUNT));
                user = (UserObj) ois.readObject();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return user;
    }

    public static boolean isLogin(Context context) {
        File file = new File(context.getFilesDir(), ACCOUNT);
        return file.exists();
    }

    public static void loginOut(Context context) {
        File dir = context.getFilesDir();
        String[] fileNameList = dir.list();
        for (String item : fileNameList) {
            File file = new File(dir, item);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
        }
    }


}
