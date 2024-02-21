<template>

    <v-data-table
        :headers="headers"
        :items="checkBenefits"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'CheckBenefitsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            checkBenefits : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/checkBenefits'))

            temp.data._embedded.checkBenefits.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.checkBenefits = temp.data._embedded.checkBenefits;
        },
        methods: {
        }
    }
</script>

