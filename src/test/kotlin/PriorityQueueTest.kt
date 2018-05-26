import io.kotlintest.specs.FunSpec
import model.BackgroundSyncRequestEvent
import model.LocationRequestEvent
import model.StatusRequestEvent
import service.RequestQueueManager

class PriorityQueueTest : FunSpec() {
    init {
        test("Event creation") {
            val requestQueueManager = RequestQueueManager()
            requestQueueManager.requestEventPriorityQueue.apply {
                add(LocationRequestEvent())
                add(BackgroundSyncRequestEvent())
                add(BackgroundSyncRequestEvent())
                add(BackgroundSyncRequestEvent())
                add(LocationRequestEvent())
                add(BackgroundSyncRequestEvent())
                add(BackgroundSyncRequestEvent())
                add(LocationRequestEvent())
                add(StatusRequestEvent())
                add(StatusRequestEvent())
                add(BackgroundSyncRequestEvent())
                add(StatusRequestEvent())
                add(LocationRequestEvent())
                add(StatusRequestEvent())
                add(LocationRequestEvent())
                add(StatusRequestEvent())
                add(LocationRequestEvent())
                add(StatusRequestEvent())
                add(LocationRequestEvent())
            }

            while(requestQueueManager.requestEventPriorityQueue.isNotEmpty()) {
                println(requestQueueManager.requestEventPriorityQueue.poll().toString())
            }
        }

    }
}