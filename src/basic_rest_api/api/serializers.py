from .models import Item, Sessions
from rest_framework import serializers


class SessionsOnlySerializer(serializers.ModelSerializer):
    class Meta:
        model = Sessions
        fields = ("id", "name")


class SessionsSerializer(serializers.ModelSerializer):
    class Meta:
        model = Sessions
        fields = ("id", "name")


class ItemSerializer(serializers.ModelSerializer):
    sessions = SessionsSerializer(many=True)

    class Meta:
        model = Item
        fields = '__all__'

    def create(self, validated_data):
        item = Item(name=validated_data.get("name"))
        item.save()
        sessions = validated_data.get('sessions')
        for session in sessions:
            Sessions.objects.create(item=item, **session)
        return validated_data
