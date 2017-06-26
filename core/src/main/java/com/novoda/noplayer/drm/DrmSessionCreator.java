package com.novoda.noplayer.drm;

import android.support.annotation.Nullable;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;

import java.util.UUID;

public interface DrmSessionCreator {

    UUID WIDEVINE_MODULAR_UUID = new UUID(0xEDEF8BA979D64ACEL, 0xA3C827DCD51D21EDL);

    @Nullable
    DrmSessionManager<FrameworkMediaCrypto> create(DefaultDrmSessionManager.EventListener eventListener);

    class DrmSessionManagerCreationException extends RuntimeException {

        DrmSessionManagerCreationException(Throwable cause) {
            super(cause);
        }
    }
}
