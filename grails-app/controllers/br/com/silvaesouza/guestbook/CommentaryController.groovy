package br.com.silvaesouza.guestbook



//import static org.springframework.http.HttpStatus

import br.com.silvaesouza.guestbook.Commentary;
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CommentaryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	//def scaffold = Comment

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [commentInstanceList:Commentary.list(params), model:[commentInstanceCount: Commentary.count()]]
    }

    def show(Commentary commentInstance) {
        [commentInstance:commentInstance]
    }

    def create() {
        respond new Commentary(params)
    }

    @Transactional
    def save(Commentary commentInstance) {
        if (commentInstance == null) {
            notFound()
            return
        }

        if (commentInstance.hasErrors()) {
            respond commentInstance.errors, view:'create'
            return
        }

        commentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'comment.label', default: 'Comment'), commentInstance.id])
                redirect commentInstance
            }
            '*' { respond commentInstance, [status: CREATED] }
        }
    }

    def edit(Commentary commentInstance) {
        [commentInstance:commentInstance]
    }

    @Transactional
    def update(Commentary commentInstance) {
        if (commentInstance == null) {
            notFound()
            return
        }

        if (commentInstance.hasErrors()) {
            respond commentInstance.errors, view:'edit'
            return
        }

        commentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Comment.label', default: 'Comment'), commentInstance.id])
                redirect commentInstance
            }
            '*'{ respond commentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Commentary commentInstance) {

        if (commentInstance == null) {
            notFound()
            return
        }

        commentInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Comment.label', default: 'Comment'), commentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comment.label', default: 'Comment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
