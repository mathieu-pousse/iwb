iwb-bootstrap
---

/products/search?q=full-text-search
 - returns a list of product essentials

/products/id/{id}
 - manages the product details. if a cookie with the current user location is available, use this value.

/products/id/{id}/location/{locationId}
 - returns the product details and use the specified location.

/materials
 - returns the list of all the existing materials

/materials/id/{id}
 - manages the material with the specified id

/materials/id/{id}/second-life/
 - returns the material with the specified id and all the  second life

/materials/id/{id}/second-life/location/{locationId}
 - manages the material with the specified id and the second life for the specified location

/location
 - returns all the locations

/location/id/{id}
 - manages the location with the specified id.

/location/search?q=full-text-search
 - returns a list of location

/images/id/{id}
 - manages the specified image
