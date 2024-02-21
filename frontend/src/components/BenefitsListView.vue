<template>

    <v-data-table
        :headers="headers"
        :items="benefitsList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'BenefitsListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "agreementId", value: "agreementId" },
                { text: "userPoint", value: "userPoint" },
                { text: "agreePoint", value: "agreePoint" },
                { text: "agreementName", value: "agreementName" },
            ],
            benefitsList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/benefitsLists'))

            temp.data._embedded.benefitsLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.benefitsList = temp.data._embedded.benefitsLists;
        },
        methods: {
        }
    }
</script>

