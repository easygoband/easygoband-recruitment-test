from .serializers import ItemSerializer, SessionsOnlySerializer
from rest_framework import viewsets
from .models import Item, Sessions
from rest_framework.permissions import IsAuthenticated
from rest_framework.authentication import TokenAuthentication

class ItemViewSet(viewsets.ModelViewSet):
    authentication_classes = [TokenAuthentication]
    permission_classes = [IsAuthenticated]
    serializer_class = ItemSerializer
    queryset = Item.objects.all()


class SessionViewSet(viewsets.ModelViewSet):
    authentication_classes = [TokenAuthentication]
    permission_classes = [IsAuthenticated]
    serializer_class = SessionsOnlySerializer
    queryset = Sessions.objects.all()
