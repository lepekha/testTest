package com.inhelp.core.models.data

import com.inhelp.R

enum class Menu(val titleResId: Int, val iconResId: Int, val backgroundResId: Int) {
    MENU_SAVE_PHOTO(titleResId = R.string.menu_save_photo, iconResId = R.drawable.menu_gradient_1, backgroundResId = R.drawable.btn_menu_save),
    MENU_REPOST_PHOTO(titleResId = R.string.menu_repost_photo, iconResId = R.drawable.menu_gradient_2, backgroundResId = R.drawable.btn_menu_repost),
    MENU_TAGS(titleResId = R.string.menu_tags, iconResId = R.drawable.menu_gradient_3, backgroundResId = R.drawable.btn_menu_tags),
    MENU_SAVE_PHOTO1(titleResId = R.string.menu_save_photo, iconResId = R.drawable.menu_gradient_4, backgroundResId = R.drawable.btn_menu_save),
    MENU_REPOST_PHOTO1(titleResId = R.string.menu_repost_photo, iconResId = R.drawable.menu_gradient_5, backgroundResId = R.drawable.btn_menu_repost);

    companion object {
        fun getMenuList() = Menu.values().toMutableList()
    }
}