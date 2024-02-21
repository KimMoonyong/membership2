<template>

    <v-data-table
        :headers="headers"
        :items="pointUseHistory"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PointUseHistoryView',
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
                { text: "usePoint", value: "usePoint" },
                { text: "useDate", value: "useDate" },
                { text: "usePointStatus", value: "usePointStatus" },
            ],
            pointUseHistory : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/pointUseHistories'))

            temp.data._embedded.pointUseHistories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.pointUseHistory = temp.data._embedded.pointUseHistories;
        },
        methods: {
        }
    }
</script>

