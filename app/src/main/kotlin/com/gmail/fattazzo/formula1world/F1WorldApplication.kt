/**
 * Copyright (C) 2016 DSpot Sp. z o.o
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gmail.fattazzo.formula1world

import com.activeandroid.app.Application
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration

class F1WorldApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // ACtive android --------------------------------------
        //ActiveAndroid.dispose()

        //val aaName = ReflectionUtils.getMetaData<String>(applicationContext, "AA_DB_NAME")

        //deleteDatabase(aaName)

        //ActiveAndroid.initialize(this)

        // Image -----------------------------------------------
        val defaultOptions = DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build()

        val config = ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(defaultOptions)
                .build()
        ImageLoader.getInstance().init(config)
    }
}