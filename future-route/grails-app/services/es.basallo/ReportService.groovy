package es.basallo

class ReportService {

    def createReport(userId) {
        Thread.start {
            Report.numberOfActiveGenerations++
            sleep 3000
            Report.numberOfActiveGenerations--
            User.withTransaction {
                def user = User.get(userId)
                new Report(name: "report_${user.reports.size()}", user: user).save()
                user.save()
            }
        }
    }
}


