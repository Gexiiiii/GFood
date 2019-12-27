package com.gexiiiii.gfood.ui.activity

import android.Manifest.permission.*
import com.gexiiiii.gfood.R
import com.gexiiiii.gfood.ui.ImmNoTiTleActivity
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions

class StartActivity : ImmNoTiTleActivity(), EasyPermissions.PermissionCallbacks {

    override fun initVariable() {
    }

    override fun layoutResId(): Int {
        return R.layout.activity_start
    }

    override fun onLazyLoad() {
    }

    override fun setListeners() {
    }

    override fun onResume() {
        super.onResume()
        requestPermission()
    }

    /**
     * 申请权限
     */
    private val permissions = arrayOf(
        // 用于进行网络定位
        ACCESS_COARSE_LOCATION,
        // 用于读取手机当前的状态
        READ_PHONE_STATE,
        // 用于写入缓存数据到扩展存储卡
        WRITE_EXTERNAL_STORAGE
    )

    companion object {
        private const val RC_LOCATION_PERM = 123
    }

    private fun requestPermission() {
        //权限
        EasyPermissions.requestPermissions(
            this,
            "请给予必要权限,拒绝权限将无法使用",
            RC_LOCATION_PERM,
            *permissions
        )
    }

    @AfterPermissionGranted(RC_LOCATION_PERM)
    private fun isRequestPermission(): Boolean {
        return if (EasyPermissions.hasPermissions(this, *permissions)) {
            MainActivity.start(this)
            finish()
            true
        } else {
            requestPermission()
            false
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, list: List<String>) {
    }

    override fun onPermissionsDenied(requestCode: Int, list: List<String>) {
    }
}
