package com.novoda.noplayer.internal.exoplayer.forwarder;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.novoda.noplayer.Player;
import com.novoda.noplayer.internal.exoplayer.playererror.DrmInitiatingError;

class DrmSessionErrorForwarder implements DefaultDrmSessionManager.EventListener {

    private final Player player;
    private final Player.ErrorListener errorListener;

    DrmSessionErrorForwarder(Player player, Player.ErrorListener errorListener) {
        this.player = player;
        this.errorListener = errorListener;
    }

    @Override
    public void onDrmKeysLoaded() {
        // TODO: Are we interested?
    }

    @Override
    public void onDrmSessionManagerError(Exception e) {
        Player.PlayerError playerError = new DrmInitiatingError(e);
        errorListener.onError(player, playerError);
    }

    @Override
    public void onDrmKeysRestored() {
        // TODO: Are we interested?
    }

    @Override
    public void onDrmKeysRemoved() {
        // TODO: Are we interested?
    }
}
