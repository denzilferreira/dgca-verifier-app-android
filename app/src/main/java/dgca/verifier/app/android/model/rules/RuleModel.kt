/*
 *  ---license-start
 *  eu-digital-green-certificates / dgca-verifier-app-android
 *  ---
 *  Copyright (C) 2021 T-Systems International GmbH and all other contributors
 *  ---
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  ---license-end
 *
 *  Created by osarapulov on 9/3/21 7:53 AM
 */

package dgca.verifier.app.android.model.rules

import android.os.Parcelable
import dgca.verifier.app.engine.data.RuleCertificateType
import dgca.verifier.app.engine.data.Type
import kotlinx.parcelize.Parcelize
import java.time.ZonedDateTime
import java.util.*

@Parcelize
data class RuleModel(
    val identifier: String,
    val type: Type,
    val version: String,
    val schemaVersion: String,
    val engine: String,
    val engineVersion: String,
    val ruleCertificateType: RuleCertificateType,
    val descriptions: Map<String, String>,
    val validFrom: ZonedDateTime,
    val validTo: ZonedDateTime,
    val affectedString: List<String>,
    val logic: String,
    val countryCode: String,
    val region: String?
): Parcelable {
    fun getDescriptionFor(languageCode: String): String {
        val description = descriptions[languageCode.toLowerCase(Locale.ROOT)]
        return if (description?.isNotBlank() == true) description else descriptions[Locale.ENGLISH.language]
            ?: ""
    }
}