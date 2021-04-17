from django.urls import path, include
from .views import ItemViewSet, SessionViewSet
from rest_framework.routers import DefaultRouter

router = DefaultRouter()
router.register('item', ItemViewSet, basename='item')
router.register('session', SessionViewSet, basename='session')

urlpatterns = [
    path('data/', include(router.urls)),
    path('data/<int:pk>/', include(router.urls)),
]
