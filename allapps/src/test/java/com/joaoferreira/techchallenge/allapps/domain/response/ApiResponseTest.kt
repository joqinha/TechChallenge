package com.joaoferreira.techchallenge.allapps.domain.response

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ApiResponseTest {

    @Test
    @DisplayName(
        "GIVEN AllApps " +
            "WHEN creating a AllApps " +
            "THEN the values should match"
    )
    fun testAllApps() {
        val appDataList = listOf(
            AppData(
                1,
                "App 1",
                "com.example.app1",
                1,
                "Store 1",
                "1.0",
                1,
                "md5",
                listOf(
                    "tag1"
                ),
                1024,
                100,
                50,
                "2024-01-01",
                "2024-01-01",
                "2024-01-01",
                4.5,
                "icon_url1",
                "graphic_url1",
                "Free"
            ),
            AppData(
                2,
                "App 2",
                "com.example.app2",
                1,
                "Store 1",
                "1.0",
                1,
                "md5",
                listOf(
                    "tag2"
                ),
                1024,
                100,
                50,
                "2024-01-01",
                "2024-01-01",
                "2024-01-01",
                4.5,
                "icon_url2",
                "graphic_url2",
                "Free"
            )
        )
        val allAppsDataList = AllAppsDataList(appDataList)

        val allApps = AllApps(allAppsDataList)

        Assertions.assertEquals(allAppsDataList, allApps.data)
    }

    @Test
    @DisplayName(
        "GIVEN AllAppsDataList " +
            "WHEN creating a AllAppsDataList " +
            "THEN the values should match"
    )
    fun testAllAppsDataList() {
        val appDataList = listOf(
            AppData(
                1,
                "App 1",
                "com.example.app1",
                1,
                "Store 1",
                "1.0",
                1,
                "md5",
                listOf(
                    "tag1"
                ),
                1024,
                100,
                50,
                "2024-01-01",
                "2024-01-01",
                "2024-01-01",
                4.5,
                "icon_url1",
                "graphic_url1",
                "Free"
            ),
            AppData(
                2,
                "App 2",
                "com.example.app2",
                1,
                "Store 1",
                "1.0",
                1,
                "md5",
                listOf(
                    "tag2"
                ),
                1024,
                100,
                50,
                "2024-01-01",
                "2024-01-01",
                "2024-01-01",
                4.5,
                "icon_url2",
                "graphic_url2",
                "Free"
            )
        )

        val allAppsDataList = AllAppsDataList(appDataList)

        Assertions.assertEquals(appDataList, allAppsDataList.list)
    }

    @Suppress("LongMethod")
    @Test
    @DisplayName(
        "GIVEN ApiResponse " +
            "WHEN creating a ApiResponse " +
            "THEN the values should match"
    )
    fun testApiResponse() {
        val status = "success"
        val responseData = ResponseData(
            ListAppsResponse(
                Datasets(
                    AllApps(
                        AllAppsDataList(
                            listOf(
                                AppData(
                                    1,
                                    "App 1",
                                    "com.example.app1",
                                    1,
                                    "Store 1",
                                    "1.0",
                                    1,
                                    "md5",
                                    listOf(
                                        "tag1"
                                    ),
                                    1024,
                                    100,
                                    50,
                                    "2024-01-01",
                                    "2024-01-01",
                                    "2024-01-01",
                                    4.5,
                                    "icon_url1",
                                    "graphic_url1",
                                    "Free"
                                ),
                                AppData(
                                    2,
                                    "App 2",
                                    "com.example.app2",
                                    1,
                                    "Store 1",
                                    "1.0",
                                    1,
                                    "md5",
                                    listOf(
                                        "tag2"
                                    ),
                                    1024,
                                    100,
                                    50,
                                    "2024-01-01",
                                    "2024-01-01",
                                    "2024-01-01",
                                    4.5,
                                    "icon_url2",
                                    "graphic_url2",
                                    "Free"
                                )
                            )
                        )
                    )
                )
            )
        )

        val apiResponse = ApiResponse(status, responseData)

        Assertions.assertEquals(status, apiResponse.status)
        Assertions.assertEquals(responseData, apiResponse.responses)
    }

    @Suppress("LongMethod")
    @Test
    @DisplayName(
        "GIVEN AppData " +
            "WHEN creating a AppData " +
            "THEN the values should match"
    )
    fun testAppData() {
        val id = 123L
        val name = "Test App"
        val packageName = "com.example.testapp"
        val storeId = 456L
        val storeName = "Google Play"
        val versionName = "1.0"
        val versionCode = 1
        val md5sum = "abc123"
        val apkTags = listOf("tag1", "tag2")
        val size = 1024L
        val downloads = 100L
        val pDownloads = 50L
        val added = "2024-05-15"
        val modified = "2024-05-15"
        val updated = "2024-05-15"
        val rating = 4.5
        val iconUrl = "https://example.com/icon.png"
        val graphicUrl = "https://example.com/graphic.png"
        val upType = "Free"

        val appData =
            AppData(
                id,
                name,
                packageName,
                storeId,
                storeName,
                versionName,
                versionCode,
                md5sum,
                apkTags,
                size,
                downloads,
                pDownloads,
                added,
                modified,
                updated,
                rating,
                iconUrl,
                graphicUrl,
                upType
            )

        Assertions.assertEquals(id, appData.id)
        Assertions.assertEquals(name, appData.name)
        Assertions.assertEquals(packageName, appData.packageName)
        Assertions.assertEquals(storeId, appData.storeId)
        Assertions.assertEquals(storeName, appData.storeName)
        Assertions.assertEquals(versionName, appData.versionName)
        Assertions.assertEquals(versionCode, appData.versionCode)
        Assertions.assertEquals(md5sum, appData.md5sum)
        Assertions.assertEquals(apkTags, appData.apkTags)
        Assertions.assertEquals(size, appData.size)
        Assertions.assertEquals(downloads, appData.downloads)
        Assertions.assertEquals(pDownloads, appData.pDownloads)
        Assertions.assertEquals(added, appData.added)
        Assertions.assertEquals(modified, appData.modified)
        Assertions.assertEquals(updated, appData.updated)
        Assertions.assertEquals(rating, appData.rating)
        Assertions.assertEquals(iconUrl, appData.iconUrl)
        Assertions.assertEquals(graphicUrl, appData.graphicUrl)
        Assertions.assertEquals(upType, appData.upType)
    }

    @Test
    @DisplayName(
        "GIVEN Datasets " +
            "WHEN creating a Datasets " +
            "THEN the values should match"
    )
    fun testDatasets() {
        val allApps = AllApps(
            AllAppsDataList(
                listOf(
                    AppData(
                        1,
                        "App 1",
                        "com.example.app1",
                        1,
                        "Store 1",
                        "1.0",
                        1,
                        "md5",
                        listOf(
                            "tag1"
                        ),
                        1024,
                        100,
                        50,
                        "2024-01-01",
                        "2024-01-01",
                        "2024-01-01",
                        4.5,
                        "icon_url1",
                        "graphic_url1",
                        "Free"
                    ),
                    AppData(
                        2,
                        "App 2",
                        "com.example.app2",
                        1,
                        "Store 1",
                        "1.0",
                        1,
                        "md5",
                        listOf(
                            "tag2"
                        ),
                        1024,
                        100,
                        50,
                        "2024-01-01",
                        "2024-01-01",
                        "2024-01-01",
                        4.5,
                        "icon_url2",
                        "graphic_url2",
                        "Free"
                    )
                )
            )
        )

        val datasets = Datasets(allApps)

        Assertions.assertEquals(allApps, datasets.all)
    }

    @Test
    @DisplayName(
        "GIVEN ListAppsResponse " +
            "WHEN creating a ListAppsResponse " +
            "THEN the values should match"
    )
    fun testListAppsResponse() {
        val datasets = Datasets(
            AllApps(
                AllAppsDataList(
                    listOf(
                        AppData(
                            1,
                            "App 1",
                            "com.example.app1",
                            1,
                            "Store 1",
                            "1.0",
                            1,
                            "md5",
                            listOf(
                                "tag1"
                            ),
                            1024,
                            100,
                            50,
                            "2024-01-01",
                            "2024-01-01",
                            "2024-01-01",
                            4.5,
                            "icon_url1",
                            "graphic_url1",
                            "Free"
                        ),
                        AppData(
                            2,
                            "App 2",
                            "com.example.app2",
                            1,
                            "Store 1",
                            "1.0",
                            1,
                            "md5",
                            listOf(
                                "tag2"
                            ),
                            1024,
                            100,
                            50,
                            "2024-01-01",
                            "2024-01-01",
                            "2024-01-01",
                            4.5,
                            "icon_url2",
                            "graphic_url2",
                            "Free"
                        )
                    )
                )
            )
        )

        val listAppsResponse = ListAppsResponse(datasets)

        Assertions.assertEquals(datasets, listAppsResponse.datasets)
    }

    @Suppress("LongMethod")
    @Test
    @DisplayName(
        "GIVEN ResponseData " +
            "WHEN creating a ResponseData " +
            "THEN the values should match"
    )
    fun testResponseData() {
        val listAppsResponse = ListAppsResponse(
            Datasets(
                AllApps(
                    AllAppsDataList(
                        listOf(
                            AppData(
                                1,
                                "App 1",
                                "com.example.app1",
                                1,
                                "Store 1",
                                "1.0",
                                1,
                                "md5",
                                listOf(
                                    "tag1"
                                ),
                                1024,
                                100,
                                50,
                                "2024-01-01",
                                "2024-01-01",
                                "2024-01-01",
                                4.5,
                                "icon_url1",
                                "graphic_url1",
                                "Free"
                            ),
                            AppData(
                                2,
                                "App 2",
                                "com.example.app2",
                                1,
                                "Store 1",
                                "1.0",
                                1,
                                "md5",
                                listOf(
                                    "tag2"
                                ),
                                1024,
                                100,
                                50,
                                "2024-01-01",
                                "2024-01-01",
                                "2024-01-01",
                                4.5,
                                "icon_url2",
                                "graphic_url2",
                                "Free"
                            )
                        )
                    )
                )
            )
        )

        val responseData = ResponseData(listAppsResponse)

        Assertions.assertEquals(listAppsResponse, responseData.listApps)
    }
}
