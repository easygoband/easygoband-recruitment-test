const assert = require('assert');

const filter = require('../code/utils/filter')

const data = [
    {
        "sessions": [
            {
                "name": "02-JUEVES",
                "id": 20
            }
        ]
    },
    {
        "sessions": [
            {
                "name": "01-ABONO",
                "id": 19
            }
        ]
    },
    {
        "sessions": [
            {
                "name": "01-ABONO",
                "id": 19
            }
        ]
    }
];

describe('Filter test', () => {

    it('should return an empty array', () => {
        const name = "03-VIERNES";
        assert.strictEqual(filter(data, name).length, 0);
    });

    it('should return an array with length two', () => {
        const name = "01-ABONO";
        assert.strictEqual(filter(data, name).length, 2);
    });

});
