**OEBB to Network DW ETL**

The program tries to redesign a GTFS database example - ÖBB Fahrplan, i.e. Austrian railways Schedule into a graph database which could later be used as a somewhat incoventional data warehouse model.


The data used in this program can be found and downloaded from the following website: https://data.oebb.at/de/datensaetze~soll-fahrplan-gtfs~ (the ~ sign is included in the website URL)

This data is thoroughly described on a GTFS website: https://gtfs.org/documentation/schedule/reference/

In order to run the program, you should set up a configuration on a Main class, with command line arguments being as follows:
1. *input directory* - the directory in which the files downloaded from the OEBB website were downloaded
2. *output directory* - the directory in which you wish to load the data warehouse
