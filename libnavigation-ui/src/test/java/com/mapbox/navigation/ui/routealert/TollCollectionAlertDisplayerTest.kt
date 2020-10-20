package com.mapbox.navigation.ui.routealert

import android.graphics.drawable.Drawable
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import com.mapbox.navigation.base.trip.model.alert.RestStopAlert
import com.mapbox.navigation.base.trip.model.alert.RestStopType
import com.mapbox.navigation.base.trip.model.alert.TollCollectionAlert
import com.mapbox.navigation.base.trip.model.alert.TollCollectionType
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.unmockkObject
import io.mockk.verify
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TollCollectionAlertDisplayerTest {

    @Before
    fun setUp() {
        mockkObject(RouteAlertDisplayerProvider)
        val tollCollectionsSource = mockk<GeoJsonSource>(relaxed = true)
        val tollCollectionsLayer = mockk<SymbolLayer>(relaxed = true)
        every {
            RouteAlertDisplayerProvider.getGeoJsonSource(any())
        } returns tollCollectionsSource
        every {
            RouteAlertDisplayerProvider.getSymbolLayer(any(), any())
        } returns tollCollectionsLayer
    }

    @After
    fun tearDown() {
        unmockkObject(RouteAlertDisplayerProvider)
    }

    @Test
    fun onNewRouteAlerts_withTollCollectionAlerts() {
        val tollCollectionAlertDisplayer = createTollCollectionAlertDisplayer()

        tollCollectionAlertDisplayer.onNewRouteAlerts(mockRouteAlertsWithTollCollectionAlerts())

        val tollCollectionAlertUiModels = mutableListOf<List<TollCollectionAlertUiModel>>()
        verify { tollCollectionAlertDisplayer.onNewRouteTollAlerts(capture(tollCollectionAlertUiModels)) }
        assertEquals(tollCollectionAlertUiModels[0].size, 2)
    }

    @Test
    fun onNewRouteAlerts_withoutTollCollectionAlerts() {
        val tollCollectionAlertDisplayer = createTollCollectionAlertDisplayer()

        tollCollectionAlertDisplayer.onNewRouteAlerts(emptyList())

        val tollCollectionAlertUiModels = mutableListOf<List<TollCollectionAlertUiModel>>()
        verify { tollCollectionAlertDisplayer.onNewRouteTollAlerts(capture(tollCollectionAlertUiModels)) }
        assertEquals(tollCollectionAlertUiModels[0].size, 0)
    }

    @Test
    fun onStyleLoaded_beforeOnNewRouteAlerts() {
        val tollCollectionAlertDisplayer = createTollCollectionAlertDisplayer()
        val style = mockk<Style>(relaxed = true)

        tollCollectionAlertDisplayer.onStyleLoaded(style)

        style.run {
            verify {
                addImage(any(), any<Drawable>())
                addSource(any())
                addLayer(any())
            }
        }
        verify { tollCollectionAlertDisplayer.onNewRouteTollAlerts(emptyList()) }
    }

    @Test
    fun onStyleLoaded_afterOnNewRouteAlerts() {
        val tollCollectionAlertDisplayer = createTollCollectionAlertDisplayer()
        val style = mockk<Style>(relaxed = true)

        tollCollectionAlertDisplayer.onNewRouteAlerts(mockRouteAlertsWithTollCollectionAlerts())
        tollCollectionAlertDisplayer.onStyleLoaded(style)

        style.run {
            verify {
                addImage(any(), any<Drawable>())
                addSource(any())
                addLayer(any())
            }
        }

        val tollCollectionAlertUiModels = mutableListOf<List<TollCollectionAlertUiModel>>()
        verify { tollCollectionAlertDisplayer.onNewRouteTollAlerts(capture(tollCollectionAlertUiModels)) }
        assertEquals(tollCollectionAlertUiModels[0].size, 2)
    }

    private fun createTollCollectionAlertDisplayer(): TollCollectionAlertDisplayer {
        val tollCollectionAlertDisplayerOptions =
            mockk<TollCollectionAlertDisplayerOptions>(relaxed = true)
        every { tollCollectionAlertDisplayerOptions.drawable } returns mockk(relaxed = true)
        return TollCollectionAlertDisplayer(tollCollectionAlertDisplayerOptions)
    }

    private fun mockRouteAlertsWithTollCollectionAlerts() = arrayListOf(
        TollCollectionAlert.Builder(Point.fromLngLat(1.0, 2.0), 123.0)
            .alertGeometry(mockk(relaxed = true))
            .tollCollectionType(TollCollectionType.TollBooth)
            .build(),
        TollCollectionAlert.Builder(Point.fromLngLat(2.0, 3.0), 456.0)
            .alertGeometry(mockk(relaxed = true))
            .tollCollectionType(TollCollectionType.TollGantry)
            .build(),
        RestStopAlert.Builder(Point.fromLngLat(1.0, 2.0), 123.0)
            .alertGeometry(mockk(relaxed = true))
            .restStopType(RestStopType.RestArea)
            .build()
    )
}
