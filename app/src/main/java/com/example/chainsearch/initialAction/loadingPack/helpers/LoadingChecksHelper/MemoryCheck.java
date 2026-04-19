package com.example.chainsearch.initialAction.loadingPack.helpers.LoadingChecksHelper;

import android.content.Context;
import android.os.StatFs;

import java.io.File;

public class MemoryCheck {
    public static boolean doesItHaveEnoughMemory(Context context, double percentage) {
        //Available Storage check
        boolean hasEnoughSpace = false;
        File storageFile = context.getFilesDir();
        StatFs stat = new StatFs(storageFile.getPath());

        long freeBytes = stat.getAvailableBytes();
        long totalBytes = stat.getTotalBytes();

        if (freeBytes >= (double) totalBytes / 100 * percentage) {
            hasEnoughSpace = true;
        }

        return hasEnoughSpace;
    }
}
