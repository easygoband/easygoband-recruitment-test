# README

To run this program, the following criteria has been followed:

## Without execution arguments

The application will retrieve an Excel file with the whole set of data retrieved from the server.

## Find an item by its ID

The application will retrieve an Excel file with those items that match the typed ID. To run it, the following example must be followed:

```
<program> searchByID 78
```

## Filter results by some fields

The application will retrieve an Excel file with those items that match one of selected filtering criteria. To run it, the following example must be followed:

```
<program> filterBy access_group_name=Abono
<program> filterBy name=sabado
<program> filterBy access_group_name=Abono name=sabado
```

As it can be seen, multiple filtering criteria can be applied. In case of indicating a string search, a partial search must be done, indicating only a word within the desired results.

The filtering can be done by:

* `access_group_name`
* `access_group_id`
* `total_uses`
* `event_id`
* `stucture_decode`
* `name`
* `id`
* `basic_product_id`

## Sort results by a field

The application will retrieve an Excel file with those items sorted by an indicated field. To run it, the following example must be followed:

```
<program> sortBy access_group_name
<program> sortBy total_uses
<program> sortBy id
```

The sorting can be applied by:

* `access_group_name`
* `access_group_id`
* `total_uses`
* `event_id`
* `structure_decode`
* `name`
* `modified`
* `id`
* `basic_product_id`