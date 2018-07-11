package com.example.mrenaud.mesrecettesdecrepes.interfaces;

import android.view.View;
// interface, c'est a dire qu'elle "passe le sel" entre les fonctions qui se rapporte a une meme action
public interface ItemClickListener {
    void onIconClick(int position);
    void onRecipeTextClick(int position);
}
