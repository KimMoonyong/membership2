<template>

    <v-card outlined>
        <v-card-title>
            PointUseHistory # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AgreementId" v-model="item.agreementId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UsePoint" v-model="item.usePoint" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="UseDate" v-model="item.useDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UsePointStatus" v-model="item.usePointStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'PointUseHistoryViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/pointUseHistories/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

