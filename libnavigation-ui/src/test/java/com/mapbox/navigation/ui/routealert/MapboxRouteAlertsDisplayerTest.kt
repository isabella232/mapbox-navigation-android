package com.mapbox.navigation.ui.routealert

import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import com.mapbox.navigation.base.trip.model.alert.RouteAlert
import io.mockk.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class MapboxRouteAlertsDisplayerTest {
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
    fun onStyleLoaded() {
        val displayer = createMapboxRouteAlertsDisplayer()
        val style = mockk<Style>(relaxed = true)

        displayer.onStyleLoaded(style)

        verify { displayer.routeAlertToll.onStyleLoaded(style) }
    }

    @Test
    fun onNewRouteAlerts() {
        val displayer = createMapboxRouteAlertsDisplayer()
        val list = mockk<List<RouteAlert>>()

        displayer.onNewRouteAlerts(list)

        verify { displayer.routeAlertToll.onNewRouteAlerts(list) }
    }

    private fun createMapboxRouteAlertsDisplayer(showToll: Boolean = true)
        : MapboxRouteAlertsDisplayer {
        val options = mockk<MapboxRouteAlertsDisplayerOptions>(relaxed = true)
        every { options.showToll } returns showToll

        return MapboxRouteAlertsDisplayer(options)
    }
}
