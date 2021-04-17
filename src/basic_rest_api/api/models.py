from django.db import models
from django.db.models.deletion import DO_NOTHING


class Item(models.Model):
    access_group_id= models.IntegerField()
    access_group_name= models.CharField(max_length=100)
    basic_product_id= models.IntegerField()
    event_id= models.IntegerField()
    modified= models.CharField(max_length=100)
    name= models.CharField(max_length=100)
    structure_decode= models.BooleanField()
    total_uses= models.IntegerField()
    
class Sessions(models.Model):
    name = models.CharField(max_length=100, unique=True)
    item= models.ForeignKey(Item, on_delete=DO_NOTHING, related_name='sessions')
